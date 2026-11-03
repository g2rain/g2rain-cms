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

脚本先执行完整 `mvn clean install`（其中包含 `verify` 阶段），再在 Startup 模块使用 Jib 的 `dockerBuild` 构建 `ghcr.io/g2rain/g2rain-cms:1.0.0` 到本地 Docker daemon。它使用镜像仓库中的 Eclipse Temurin `25.0.4.1_1-jre` 基础镜像、`com.g2rain.Application` 入口和声明端口 `8080`；CI 在同一 Startup Jib 配置上执行 `jib:build`。

## GHCR 发布与拉取

GHCR 工作流仅在推送精确 `v<major>.<minor>.<patch>` tag 时运行。工作流拒绝不在 `origin/main` 历史中的 tag、缺少同名非空 `docs/releases/v<版本>.md` 的提交，以及与根 Maven `project.version` 不一致的 tag。它先执行 `mvn -U clean install`（含测试阶段），然后用 Jib 推送：

- `ghcr.io/g2rain/g2rain-cms:<版本>`，例如 `:1.0.0`；
- `ghcr.io/g2rain/g2rain-cms:sha-<完整提交 SHA>`；
- 不推送 `latest`。

GHCR 工作流不会在普通分支、Pull Request 或手动触发时发布，也不会创建 GitHub Release 或部署服务。发布成功只会在两个 tag 都由 Jib 完成推送后写入 Actions Summary；登录或部分 layer 上传不表示发布成功。随后调用 Maven API 工作流；Maven 上传失败会使调用 job 失败，已推送镜像不会自动回滚。

## GitHub Maven Packages：CMS API

镜像成功后，`publish-maven.yml` 使用同一 tag 提交上传父 POM `com.g2rain:g2rain-cms:pom:1.0.0` 和 API `com.g2rain:g2rain-cms-api:jar:1.0.0`，并保留 sources/Javadoc 配置；`-pl g2rain-cms-api -am` 不选择 Biz/Startup。该工作流也可手动运行，但所选提交必须位于 `origin/main` 历史中。目标仓库为 `https://maven.pkg.github.com/g2rain/g2rain-cms`。重复上传同一稳定版本可能冲突，不删除或覆盖既有版本。

两个工作流在 `$RUNNER_TEMP` 建立权限为 `600` 的 Maven settings，激活 `g2rain-common` 仓库 `https://maven.pkg.github.com/g2rain/g2rain-common`，并以同名 server 引用环境凭据。Maven 发布配置额外保留 ID 为 `github` 的 deploy server。`com.g2rain:g2rain-common:1.0.9` 必须事先可从所属仓库解析，本仓后续 API 上传不能补齐外部包。根 Reactor 的其他外部 Starter 也必须有可解析来源；本地缓存不证明 CI 可用。跨仓库读取需核对包的 Actions access 和组织 Packages 策略，单独声明 `packages: write` 不保证访问权限。

消费方需为 CMS Maven URL 配置 repository，并在 settings 中配置匹配的 server ID 和安全注入的凭据。个人读取使用具备 `read:packages` 的 PAT classic；其他仓库的 Actions `GITHUB_TOKEN` 需要 CMS 包授予读取权限。公开 GHCR 镜像可匿名拉取不意味着 Maven 包可匿名下载。

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

本地镜像脚本包含 Maven `verify`，但不能替代生产依赖联通、Gateway 路由、数据库迁移与部署后的集成验证。CI 执行构建/测试、镜像推送和 API Maven 上传，不进行消费者解析或实际部署验证。根据 Jib 配置，镜像包含 Startup 类、依赖和 JAR 类路径资源；源码中的 `g2rain-cms-startup/src/main/resources/application.yml` 与 `application-dev.yml` 会进入 JAR，镜像内路径待实际构建检查。`.dockerignore` 不控制 Jib，也不会移除 Git 已跟踪或 JAR 中的开发凭据。

