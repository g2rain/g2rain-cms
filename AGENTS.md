# g2rain-cms Agent Instructions

本文件是 AI Coding 在本项目中的执行入口。项目事实位于 `docs`、当前源码、POM、运行配置和数据库脚本；中央架构规则位于 g2rain 仓库。

## 架构基线

- 仓库类型：CMS 内容管理业务服务
- 目标 Profile：`java-domain-service 1.0.0`
- 固定引用：`architecture-v1.0.0`
- 当前状态：计划采用，尚未在中央项目目录登记
- 项目事实：`docs/project.yaml`
- 文档入口：`docs/index.md`
- 已知偏差：`docs/architecture/deviations.md`

## 开始工作前

1. 读取 `docs/project.yaml`、中央 Profile 和 `docs/architecture/deviations.md`。
2. 按任务读取架构、需求、开发、安全或运维专题文档。
3. 核对源码、POM、配置、数据库脚本、测试和 Git Diff；文档目标不代表当前已经实现。

## 强制边界

- 保持 `g2rain-cms-startup → g2rain-cms-biz → g2rain-cms-api`。
- API 模块只发布查询模型、VO 和明确的受信契约；普通 App 写操作经 Gateway 调用 Biz Controller。
- Controller 只做协议适配，领域规则、事务、幂等和租户校验位于 Service。
- CMS 拥有站点、空间、栏目、页面、文章、分类、标签及文章标签关系数据。
- `organId` 必须来自可信上下文并贯穿查询、写入与持久化；不能只相信请求参数。
- `@IgnoreIsolation` DAO 方法只能由明确的受信 Service 调用并补足组织范围校验。
- 逻辑删除唯一键必须明确删除后释放或永久占位语义；并发去重不能只依赖先查后写。
- 不记录或返回 Token、密钥、生产凭证和非必要个人信息；文章正文等内容按最小化原则返回。
- 修改 API、数据库、配置、模块、依赖或长期设计时同步更新 docs 和 README。
- 不添加只供 Agent 使用的项目脚本。

## 完成前

- 执行 `mvn clean verify`，无法执行时说明原因和风险。
- 检查 API/Biz/Startup 依赖、Controller 路径、Mapper SQL、租户隔离、事务和 Git Diff。
- 检查 Markdown 相对链接、`docs/project.yaml`、端口、Profile 和启动命令的一致性。
- 按 `docs/development/definition-of-done.md` 报告已验证项、未验证项和剩余偏差。
- 保留用户已有修改，不覆盖业务源码、配置、构建产物或无关文件。

