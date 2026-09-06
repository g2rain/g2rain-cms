# 部署

## 可执行 JAR

```bash
mvn clean package
java -jar g2rain-cms-startup/target/g2rain-cms-startup-1.0-SNAPSHOT.jar
```

## 本地 Docker 镜像

```bash
./build.sh <tag>
```

脚本先以跳过测试方式安装整个 Reactor，再在 Startup 模块使用 Jib 构建 `g2rain/g2rain-cms:<tag>`；基础运行时为 Java 25 JRE，声明端口 8080。

上线前验证：

- 外部注入 MySQL、Nacos 和所需 Redis 配置；
- Gateway 路由、服务发现名称和健康检查一致；
- 初始化 DDL 与增量迁移的边界清楚；
- 组织隔离、写接口授权和敏感字段最小化；
- 镜像版本、配置版本、数据库迁移顺序与回滚方案可追踪。

`build.sh` 使用 `-DskipTests=true`，不能替代发布前的 `mvn clean verify` 和集成测试。

