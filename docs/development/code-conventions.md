# 代码约定

- 模块依赖保持 `startup → biz → api`。
- Controller 只处理协议、绑定、校验入口和响应包装。
- Service 承担领域用例、事务、幂等、租户和跨 DAO 协调。
- DAO/Mapper 只承担持久化，不在 Converter 中访问数据库或网络。
- API 模块发布查询 DTO、VO 和明确业务契约，不发布 PO、Service 或宽泛远程 CRUD。
- Biz 写入 DTO 不作为其他服务的编译期契约。
- 新增公共类型和接口提供清晰 Javadoc/OpenAPI 语义，避免沿用“表信息”等生成器占位描述。
- ID、时间、状态和逻辑删除使用项目统一抽象；失败写入通过明确错误码报告。
- 修改接口、字段、SQL、配置或运行流程时同步文档。

