#!/usr/bin/env bash
set -euo pipefail

# 切到脚本所在目录（确保在 g2rain-cms 根目录执行）
cd "$(dirname "$0")"

APP_IMAGE="${APP_IMAGE:-ghcr.io/g2rain/g2rain-cms}"

# 第一个参数可选；默认使用 Maven 项目版本。第二个参数为 push 时推送到镜像仓库，其他情况载入本地 Docker。
PROJECT_VERSION="$(mvn --batch-mode --no-transfer-progress -q -DforceStdout help:evaluate -Dexpression=project.version | tail -n 1)"
TAG="${1:-$PROJECT_VERSION}"
MODE="${2:-local}"

if [[ "$TAG" != "$PROJECT_VERSION" ]]; then
  echo "Image tag '$TAG' must equal Maven project version '$PROJECT_VERSION'." >&2
  exit 1
fi

case "$MODE" in
  local) JIB_GOAL="jib:dockerBuild" ;;
  push) JIB_GOAL="jib:build" ;;
  *)
    echo "Usage: $0 [version] [local|push]" >&2
    exit 1
    ;;
esac

JIB_TAG_ARGS=()
if [[ -n "${EXTRA_TAGS:-}" ]]; then
  JIB_TAG_ARGS+=("-Djib.to.tags=${EXTRA_TAGS}")
fi

echo "Building Docker image: ${APP_IMAGE}:${TAG}"

# 先在根目录完整构建、测试并安装整个项目（包括所有子模块），以便子模块复用相同产物构建镜像。
# install 生命周期包含 verify 阶段。
mvn --batch-mode --no-transfer-progress clean install

# 然后进入 startup 子模块，执行 Jib 构建
cd g2rain-cms-startup

mvn --batch-mode --no-transfer-progress -DskipTests=true \
  compile "$JIB_GOAL" \
  "-Djib.to.image=${APP_IMAGE}:${TAG}" \
  "${JIB_TAG_ARGS[@]}"
