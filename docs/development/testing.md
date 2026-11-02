# 测试策略

## 当前基线

```bash
mvn clean verify
```

2026-09-05 验证通过 4 个 Reactor 项目，但 API、Biz 和 Startup 均报告 `No tests to run`，实际测试数为 0。该结果只证明当前工作树能够编译、打包并生成 source/Javadoc 产物。

## 应补充的验证

| 层级 | 重点 |
| --- | --- |
| Service | 状态变化、保存/删除、文章标签批量绑定、事务和错误语义 |
| DAO/Mapper | 正文映射、分页、逻辑删除、乐观锁、组织隔离与 WithoutIsolation |
| 数据库集成 | 唯一键、并发重复标签、删除后重建和真实事务回滚 |
| Controller/API | 参数校验、响应、错误码、正文最小化和越权输入 |
| Startup | 默认与 Nacos Profile、Bean 组装、Actuator 和关键配置绑定 |
| 端到端 | CMS App → Gateway → CMS 的认证、权限、租户和主要内容流程 |

缺陷修复必须增加可复现原问题的回归测试；Mock 不能替代数据库、AOP 和配置集成测试。

