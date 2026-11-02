# API 约定

## 契约边界

- API 模块提供每个领域对象的 `/list` 与 `/page` 查询契约。
- `TagApi` 额外提供 `POST /tag/by_article`，按文章 ID 列表返回标签映射；它是查询语义而非写入。
- Biz Controller 提供 `/save`、`/{id}` 删除，以及部分对象的 `/update_status`。
- `POST /article_tag_relation/batch_add_tags` 是文章批量绑定标签用例。

## 编码要求

- 查询条件使用 API 模块的 `SelectDto`；写入使用 Biz 模块 DTO。
- Controller 对请求体使用 Bean Validation，并在 Service 再执行领域和租户校验。
- 普通 App 请求通过 Gateway，不能用内部 URL 或 OpenAPI 隐藏代替鉴权。
- 受信内部查询契约应明确调用方、服务身份、超时、兼容性和字段最小化。
- 大正文与敏感来源字段不应默认进入列表契约；列表、详情和管理视图分别设计。
- 逻辑删除、乐观锁失败、重复关系和非法状态使用稳定错误语义。

当前文章契约的正文返回和详情删除处于未提交变更中，见[架构偏差](../architecture/deviations.md)。

