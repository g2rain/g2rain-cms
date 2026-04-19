# G2rain CMS

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-25-437291?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.1.1-586069?logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)
[![Maven](https://img.shields.io/badge/build-Maven-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)

面向多租户 SaaS 的 **内容管理（CMS）微服务**：提供站点、空间、栏目、页面、文章与分类、标签及文章—标签关系等能力的 **REST API**；持久化使用 **MyBatis + MySQL**，运行期通过 **Nacos** 做服务发现与动态配置，并集成 **Redis**、**g2rain-starter-mybatis-extensions** / **分页** 等内部 Starter；默认启用 **虚拟线程**（`spring.threads.virtual.enabled: true`）。

本项目由 **[谷雨开源](https://g2rain.com)**（G2Rain）社区维护，采用 **Apache License 2.0** 开源协议发布。

---

## 目录

- [功能概览](#功能概览)
- [技术栈](#技术栈)
- [模块结构](#模块结构)
- [环境要求](#环境要求)
- [快速开始](#快速开始)
- [数据库初始化](#数据库初始化)
- [配置说明](#配置说明)
- [OpenAPI / Swagger UI](#openapi--swagger-ui)
- [构建与镜像](#构建与镜像)
- [参与贡献](#参与贡献)
- [许可证](#许可证)

---

## 功能概览

以下根据当前 **`g2rain-cms-biz`** 中的 **Controller** 与领域划分归纳（具体字段与接口以代码及 OpenAPI 为准）。

| 领域 | HTTP 前缀（示例） | 说明 |
|------|-------------------|------|
| **站点** | `/web_site` | 站点维护。 |
| **空间** | `/space` | 内容空间（官网 / 知识库 / 内部等类型，见库表注释）。 |
| **栏目** | `/channel` | 栏目树、列表 / 页面 / 外链等类型。 |
| **页面** | `/page` | 页面内容。 |
| **文章** | `/article` | 文章主数据。 |
| **文章分类** | `/article_category` | 文章与分类关系。 |
| **标签** | `/tag` | 标签。 |
| **文章—标签** | `/article_tag_relation` | 文章与标签关联。 |

**集成能力**（与 `g2rain-cms-startup` 的 `application.yml` 一致）：

- **Nacos**：服务发现 + 动态配置；可选导入 **`g2rain-cms.yml`**（`spring.config.import`）。
- **多租户数据隔离**：`g2rain.data.isolation.enabled: true`（与业务表 `organ_id` 等设计配合）。
- **Web 层开关**：`g2rain.web.*`（登录守卫、身份注入、统一 JSON 异常、Result Mixin 等）。
- **Actuator**：`health`、`info`；**springdoc-openapi** 提供接口文档。

**持久化**：MyBatis，当前 **`g2rain-cms-biz`** 下 **8** 个 Mapper XML（`src/main/resources/mybatis/mapper`）。

---

## 技术栈

| 类别 | 说明 |
|------|------|
| 运行时 | Java **25**（`maven.compiler.release`） |
| 框架 | **Spring Boot** 4.0.5、**Spring Cloud** 2025.1.1、**Spring Cloud Alibaba (Nacos)** |
| Web | **Spring MVC**、**虚拟线程**（默认开启） |
| 持久化 | **MyBatis Spring Boot**、**MySQL**（`mysql-connector-j`） |
| 缓存 | **Spring Data Redis**、**g2rain-starter-data-redis** |
| 其他 | **MapStruct**、**Lombok**、**springdoc-openapi**（WebMVC UI）、**g2rain-starter-mybatis-extensions**、**g2rain-starter-aegis-core**、**g2rain-common** 等 |

> 工程依赖若干 `com.g2rain` 内部 Starter 与 **g2rain-generator-maven-plugin**（根 `pom` 的 `pluginManagement`）。本地完整构建需能解析对应 **Maven 仓库**。

---

## 模块结构

```
g2rain-cms/
├── g2rain-cms-api/       # 对外契约：DTO、校验注解、Swagger 注解等
├── g2rain-cms-biz/       # 业务实现：Controller、Service、DAO、MyBatis XML
├── g2rain-cms-startup/   # 可执行应用：Spring Boot 入口、springdoc 等
└── scripts/cms.sql       # MySQL 建库建表示例
```

主类：`com.g2rain.Application`（位于 **startup** 模块）。

---

## 环境要求

- **JDK 25**
- **Apache Maven 3.9+**（推荐）
- 运行期：**MySQL**、**Redis**、**Nacos**（数据源与 Redis 等敏感项建议放在 **Nacos** `g2rain-cms.yml` 或环境变量中）

---

## 快速开始

### 1. 克隆仓库

```bash
git clone <你的仓库克隆地址>
cd g2rain-cms
```

### 2. 编译

```bash
mvn clean package -DskipTests
```

### 3. 运行

```bash
java -jar g2rain-cms-startup/target/g2rain-cms-startup-1.0-SNAPSHOT.jar
```

或在 **startup** 模块：

```bash
cd g2rain-cms-startup
mvn spring-boot:run
```

- 默认 HTTP 端口：**8080**（`SERVER_PORT`，见 `g2rain-cms-startup/src/main/resources/application.yml`）。
- 注册到 Nacos 的 **`spring.application.name`** 为 **`g2rain-cms`**。
- 当前父 POM **`version`** 为 **`1.0-SNAPSHOT`**，可执行 JAR 文件名随该版本变化；属性中的 **`revision`**（如 `1.0.5`）用于根工程插件（如 Archetype / 发布）坐标，**不必**与 `1.0-SNAPSHOT` 相同。

---

## 数据库初始化

在 MySQL 中执行仓库内脚本（可按环境修改库名与账号）：

```bash
mysql -u root -p < scripts/cms.sql
```

脚本默认创建库 **`g2rain_cms`** 及 **space / channel / page / article** 等相关表，与 **Mapper** 命名一致。

---

## 配置说明

基线配置见 **`g2rain-cms-startup/src/main/resources/application.yml`**；**数据源 `spring.datasource.*`、Redis `spring.data.redis.*`** 等通常放在 Nacos 的 **`g2rain-cms.yml`**（与本机 `optional:nacos:...` 导入一致）。

| 变量 / 配置 | 说明 |
|-------------|------|
| `SERVER_PORT` | HTTP 端口，默认 **8080** |
| `SPRING_PROFILES_ACTIVE` | Spring Profile，默认 **dev** |
| `NACOS_SERVER_ADDR` | Nacos 地址，默认 `127.0.0.1:8848` |
| `SPRING_CLOUD_NACOS_*` | Nacos 鉴权、命名空间、分组等（生产勿使用弱默认口令） |
| `g2rain.web.*` | Web 层开关（登录守卫、身份注入、统一 JSON 异常等） |
| `g2rain.data.isolation.enabled` | 多租户数据隔离开关 |

---

## OpenAPI / Swagger UI

- `application.yml` 中配置：`springdoc.api-docs.path=/v3/api-docs`，**Swagger UI** 路径为 **`/swagger-ui.html`**。
- 启动后访问：`http://localhost:${SERVER_PORT}/swagger-ui.html`（端口以实际为准）。

---

## 构建与镜像

`g2rain-cms-startup` 已配置 **Jib**（基础镜像 **`eclipse-temurin:25-jre`**，镜像名 **`g2rain/g2rain-cms:${project.version}`**）。示例：

```bash
mvn -pl g2rain-cms-startup -am clean package -DskipTests
# Jib 示例（需配置镜像仓库权限）
mvn -pl g2rain-cms-startup -am compile jib:dockerBuild
```

容器内示例暴露 **8080**；**实际监听端口**仍以 **`SERVER_PORT`** / Nacos 为准。

---

## 参与贡献

欢迎通过 Issue 讨论缺陷与需求，通过 Pull Request 提交修改。提交前建议在本地执行 **`mvn clean package`**（或你们约定的 CI 命令），并在 PR 中说明行为变更与兼容性。

---

## 许可证

本仓库适用 **Apache License, Version 2.0**，见 [LICENSE](LICENSE)。

```
Copyright © 2026 g2rain.com
```

---

## 链接

- **组织**：谷雨开源（G2Rain）
- **官网**：<https://www.g2rain.com>
- 将 `<你的仓库克隆地址>` 替换为实际 Git 托管地址。
