# 部署

## 可执行 JAR

```bash
mvn clean package
java -jar g2rain-cms-startup/target/g2rain-cms-startup-1.0.0.jar
```

## 本地 Docker 镜像

```bash
./build.sh 1.0.0 local
```

脚本先执行完整 `mvn clean install`（其中包含 `verify` 阶段），再在 Startup 模块使用 Jib 的 `dockerBuild` 构建 `ghcr.io/g2rain/g2rain-cms:1.0.0` 到本地 Docker daemon。它使用 Eclipse Temurin `25.0.4.1_1-jre` 基础镜像、`com.g2rain.Application` 入口和声明端口 `8080`；CI 推送复用同一 Jib 配置。

## GHCR 发布与拉取

GitHub Actions 仅在推送精确 `v<major>.<minor>.<patch>` tag 时运行。工作流拒绝不在 `origin/main` 历史中的 tag、缺少同名非空 `docs/releases/v<版本>.md` 的提交，以及与根 Maven `project.version` 不一致的 tag。它先执行 `mvn clean verify`，然后用 Jib 推送：

- `ghcr.io/g2rain/g2rain-cms:<版本>`，例如 `:1.0.0`；
- `ghcr.io/g2rain/g2rain-cms:sha-<完整提交 SHA>`；
- 不推送 `latest`。

工作流不会在普通分支、Pull Request 或手动触发时发布，也不会创建 GitHub Release 或部署服务。发布成功只会在两个 tag 都由 Jib 完成推送后写入 Actions Summary；登录或部分 layer 上传不表示发布成功。

包首次推送后，请在 GitHub Packages 的 **Package settings → Change visibility → Public** 将包设为公开。组织管理员禁止修改时联系管理员。已有 GHCR 包如出现 `denied`，先在 **Package settings → Actions access** 授予 `g2rain/g2rain-cms` 写权限，并核对组织 Packages 策略；工作流的 `packages: write` 并不能绕过这些设置。

匿名拉取仅在包公开后可用：

```bash
docker pull ghcr.io/g2rain/g2rain-cms:1.0.0
```

GHCR 推送、匿名拉取、在线演示和实际部署验证是相互独立的状态；本仓库没有将任一状态作为另一状态已完成的证据。

上线前验证：

- 外部注入 MySQL、Nacos 和所需 Redis 配置；
- Gateway 路由、服务发现名称和健康检查一致；
- 初始化 DDL 与增量迁移的边界清楚；
- 组织隔离、写接口授权和敏感字段最小化；
- 镜像版本、配置版本、数据库迁移顺序与回滚方案可追踪。

本地镜像脚本包含 Maven `verify`，但不能替代生产依赖联通、Gateway 路由、数据库迁移与部署后的集成验证。CI 也只执行 Maven 构建/测试和镜像推送，不进行实际部署验证。

