# g2rain-cms

## 1. 徽标与状态标识

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-25-437291?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.1.1-586069?logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)
[![Maven](https://img.shields.io/badge/build-Maven-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)

## 2. 项目简介

`g2rain-cms` 是 G2rain 平台中的内容管理后端服务，围绕站点、栏目、页面、文章、标签、文章分类与内容空间等对象提供标准化接口能力，用于支撑内容类子应用、站点运营与内容交付场景。

## 3. 平台定位

在 G2rain“企业级 AI 原生开源 SaaS 平台”体系中，`g2rain-cms` 位于业务域扩展层，承担内容管理领域服务的角色。

它主要服务以下场景：
- 为 `g2rain-cms-app` 提供文章、页面、栏目、站点、标签等内容对象的后端能力
- 为平台内容类子应用提供标准化 CRUD 与分页查询接口
- 为官网、专题页、内容运营和后续营销内容场景提供统一的领域实现基础
- 与平台统一认证、统一网关、统一资源注册体系协同，形成内容应用的标准接入方式

它与 `g2rain-cms-app`、`g2rain-basis`、`g2rain-iam`、`g2rain-gateway-webmvc`、`g2rain-gateway-webflux` 协同工作。

## 4. 核心能力

本章回答“这个仓库在平台里提供什么能力、解决什么问题”。

- 站点与栏目管理能力：解决多站点、多栏目内容组织的问题，通过 `WebSite`、`Channel` 相关接口沉淀内容导航与承载结构。
- 页面与内容空间管理能力：解决页面资源与内容归属管理的问题，通过 `Page`、`Space` 相关模型支撑页面级内容组织与隔离。
- 文章与分类标签管理能力：解决文章内容结构化管理的问题，通过 `Article`、`ArticleCategory`、`Tag`、`ArticleTagRelation` 提供内容分类、标签关联与分页查询能力。
- 标准化内容 CRUD 能力：解决业务域服务快速落地与长期一致性维护的问题，通过统一的 DTO / VO / Service / Dao / Mapper 结构提供标准化接口实现。
- 内容域服务配置接入能力：解决内容服务在平台环境中的运行接入问题，通过 Nacos 注册发现、外部配置拉取与统一异常处理接入平台运行环境。
- 镜像交付能力：解决内容服务标准部署与交付的问题，通过 `build.sh` 与 `Jib` 提供默认镜像构建入口。

## 5. 技术栈

- 语言与运行时：`Java 25`
- 后端框架：`Spring Boot 4.0.5`、`Spring Cloud 2025.1.1`
- 配置与注册：`Nacos Discovery`、`Nacos Config`
- 持久化：`MyBatis Spring Boot Starter 4.0.1`
- 对象转换：`MapStruct 1.6.3`
- 平台基础依赖：`g2rain-common`、`g2rain-starter-aegis-core`、`g2rain-starter-data-redis`、`g2rain-starter-mybatis-extensions`、`g2rain-starter-spring-doc`
- 构建与交付：`Maven`、`Jib`、`build.sh`

## 6. 快速开始

### 环境要求

- `JDK 25`
- `Maven 3.9+`
- 可用的 `Nacos`
- 可用的数据库与相关平台基础依赖环境

### 关键配置

当前仓库的关键运行配置主要来自 `g2rain-cms-startup/src/main/resources/application.yml` 与 Nacos 配置中心。

| 变量名 | 说明 | 典型用途 |
| --- | --- | --- |
| `SERVER_PORT` | 服务端口 | 默认 `8080` |
| `SPRING_PROFILES_ACTIVE` | 启动环境 | 默认 `dev` |
| `NACOS_SERVER_ADDR` | Nacos 地址 | 服务注册与配置拉取 |
| `SPRING_CLOUD_NACOS_DISCOVERY_*` | 注册中心配置 | 服务发现 |
| `SPRING_CLOUD_NACOS_CONFIG_*` | 配置中心配置 | 动态配置 |

### 本地构建

```bash
mvn clean package -DskipTests
```

### 本地运行

```bash
mvn -pl g2rain-cms-startup spring-boot:run
```

### 镜像构建

```bash
./build.sh
./build.sh 1.0.0
```

或：

```bash
cd g2rain-cms-startup
mvn -DskipTests=true compile jib:dockerBuild -Djib.to.image=g2rain/g2rain-cms:latest
```

## 7. 项目结构

本章回答“代码与模块是如何组织的、排查和扩展时应该先看哪里”。

```text
g2rain-cms/
├── build.sh
├── codegen.properties
├── pom.xml
├── g2rain-cms-api/
├── g2rain-cms-biz/
│   ├── controller
│   ├── service
│   ├── dao
│   ├── converter
│   └── resources/mybatis/mapper
└── g2rain-cms-startup/
    └── src/main/resources/
```

### 结构说明

- `g2rain-cms-api`：对外暴露 CMS 领域接口契约、查询模型与返回模型。
- `g2rain-cms-biz/controller`：承载 `article`、`channel`、`page`、`space`、`tag`、`web_site` 等 HTTP 入口。
- `g2rain-cms-biz/service/impl`：承载领域服务实现，是排查业务逻辑时的第一入口。
- `g2rain-cms-biz/dao` 与 `resources/mybatis/mapper`：承载 DAO 接口与 SQL 映射。
- `g2rain-cms-startup`：承载服务启动、Profile 配置、Nacos 接入与运行时配置。
- `build.sh`：仓库默认镜像构建入口。

## 8. 核心业务流程

本章回答“这些能力在运行时是如何串起来工作的”。

#### 1. 内容对象标准 CRUD 主线

- 前端子应用通过 `/article`、`/channel`、`/page`、`/space`、`/tag`、`/web_site` 等控制器访问内容服务。
- Controller 层直接实现 `g2rain-cms-api` 中定义的接口契约。
- Service 层完成 DTO 转 PO、分页查询、创建更新、删除等标准处理。
- DAO 与 MyBatis Mapper 完成最终持久化。

#### 2. 文章内容维护主线

- 客户端提交文章 DTO 到 `ArticleController.save`。
- `ArticleServiceImpl` 使用 `ArticleConverter` 完成模型转换。
- 新增时使用 `IdGenerator` 生成主键，并使用 `Moments.now()` 写入创建、更新时间。
- 更新时按主键回写，形成统一的文章保存链路。

#### 3. 文章标签关联主线

- 客户端在文章编辑场景中提交标签关联请求。
- `ArticleTagRelationServiceImpl.batchAddTags` 会先查出现有文章标签关系。
- 系统通过 `LinkedHashSet` 去重，再仅写入新增关联，避免重复绑定。
- 最终批量写入关系表，保证文章标签关联链路稳定可控。

#### 4. 平台接入与交付主线

- 服务启动时由 `g2rain-cms-startup` 读取本地配置与 Nacos 配置。
- 服务注册到平台运行环境，并通过统一配置接入日志、异常处理和接口文档能力。
- 交付阶段通过根目录 `build.sh` 先执行全仓 `mvn clean install`，再进入 `g2rain-cms-startup` 使用 `jib:dockerBuild` 输出镜像。

## 9. 常用命令

```bash
mvn clean package
mvn -pl g2rain-cms-startup spring-boot:run
mvn test
./build.sh
./build.sh 1.0.0
```

## 10. 质量与测试

- 当前仓库已具备标准 Maven 多模块结构与统一服务实现风格。
- 当前扫描重点集中在主源码结构，后续建议优先增加文章、标签关系、页面承载等关键场景测试。
- 提交前建议结合实际环境验证 Nacos、数据库与前端联调链路。

## 11. 相关仓库

- `g2rain-cms-app`：CMS 前端子应用
- `g2rain-basis`：资源、应用、角色与权限治理底座
- `g2rain-iam`：统一身份认证服务
- `g2rain-gateway-webmvc`：平台网关实现之一
- `g2rain-gateway-webflux`：平台网关实现之一

## 12. 使用建议

- 适合作为内容域后端服务独立部署，并由内容类子应用接入。
- 当新增内容对象时，建议继续沿用当前统一的 `api / biz / startup` 与生成器约定。
- 当需要快速对接前端子应用时，优先复用现有分页、状态、主键和时间字段处理方式。

## 13. 贡献指南

欢迎通过文档改进、Issue 反馈、测试补充、代码优化、功能增强等形式参与贡献。

建议流程：
1. Fork 本仓库
2. 创建特性分支
3. 提交修改
4. 推送分支
5. 提交 Pull Request

提交前请尽量确保：
- 遵循现有技术栈与代码规范
- 补充必要测试
- 更新相关文档
- 确保测试通过

## 14. 许可证

本项目基于 [Apache 2.0许可证](LICENSE) 开源。

## 15. 联系我们

- **站点**: https://www.g2rain.com/
- **Issues**: [GitHub Issues](https://github.com/g2rain/g2rain/issues)
- **讨论**: [GitHub Discussions](https://github.com/g2rain/g2rain/discussions)
- **邮箱**: g2rain_developer@163.com

## 16. 致谢

感谢所有为这个项目做出贡献的开发者们。

如果这个项目对您有帮助，欢迎 Star 支持。
