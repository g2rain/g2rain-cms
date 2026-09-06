# 需求索引与模板

当前没有被项目文档选中的 active requirement。执行 `develop` 时，必须由本索引明确标记唯一活动需求，或由用户明确指定需求。

## 状态

- `draft`：仍在澄清。
- `active`：当前允许执行的唯一需求。
- `accepted`：已验收。
- `superseded`：已被后续需求或 ADR 替代。

## 模板

```md
# REQ-YYYY-NNN：标题

- 状态：draft
- 负责人：
- 目标 Profile：java-domain-service 1.0.0

## 背景
## 目标
## 非目标
## 验收条件
## API 与兼容性
## 租户、权限与敏感信息
## 事务、并发与幂等
## 数据库迁移与回滚
## 测试计划
## 文档同步
```

