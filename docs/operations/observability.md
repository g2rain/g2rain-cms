# 可观测性

- Startup 引入 Spring Boot Actuator，实际暴露端点由 `management.endpoints.web.exposure.include` 控制。
- 日志可按 `com.g2rain.cms.dao` 调整级别；生产环境避免输出完整正文、Token、数据库凭据和个人信息。
- 建议记录稳定的 trace ID、调用方应用、组织范围、接口、耗时、结果类别和错误码，不记录敏感载荷。
- 文章发布、状态变化、删除、标签批量绑定和隔离绕过应具备可审计事件。
- 监控至少覆盖请求错误率/延迟、数据库连接与慢查询、Nacos 注册/配置刷新、分页大查询、正文响应体积和标签重复冲突。
- 当前仓库未提供专用 metrics、trace 或告警文档；生产阈值和仪表盘需在部署环境验证。

