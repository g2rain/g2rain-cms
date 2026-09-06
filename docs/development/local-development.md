# 本地开发

## 前置条件

- JDK 25。
- Maven 3.9 或兼容版本。
- MySQL 8.0.13 或更高版本。
- 可用的 Nacos；Redis 是否必需取决于当前启用的 Starter 与外部配置。

## 初始化数据库

`scripts/cms.sql` 是新环境初始化脚本，包含 CMS 领域表。它不是生产增量迁移脚本；已有数据环境必须单独设计和审核迁移。

## 构建与启动

```bash
mvn clean verify
mvn -pl g2rain-cms-startup -am spring-boot:run
```

默认服务名为 `g2rain-cms`，端口为 8080，Profile 为 `dev`。本地数据库和 Nacos 配置必须使用开发环境值，禁止提交生产凭据。

## 代码生成

```bash
mvn g2rain-generator:generate
```

生成器读取根目录 `codegen.properties`。运行前检查 Git 状态和数据库连接，生成后逐项 Review API/Biz/Mapper 变化并执行完整验证。

