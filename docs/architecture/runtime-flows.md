# 核心运行流程

## 内容维护

1. 用户在 `g2rain-cms-app` 完成 IAM 认证。
2. App 携带 Token 经 Gateway 调用 CMS Controller。
3. Controller 绑定查询或写入 DTO，并委托领域 Service。
4. Service 生成 ID、设置时间、执行状态/关系逻辑并调用 DAO。
5. MyBatis Mapper 对 MySQL 执行查询、写入、乐观锁更新或逻辑删除。
6. 服务使用统一 `Result`/`PageData` 返回结果。

## 文章标签批量绑定

1. 接收文章 ID 与标签 ID 列表。
2. 去除空值和请求内重复标签。
3. 查询文章已有关系并过滤已存在项。
4. 为新增关系生成 ID 和时间，在事务内批量插入。

当前数据库没有文章与标签关系的唯一约束，先查后写不能完全防止并发重复，见[已知偏差](deviations.md)。

## 启动与配置

Startup 默认以 `dev` Profile、8080 端口启动，装配虚拟线程、Web、Actuator、Nacos、MyBatis、数据隔离和 SpringDoc。生产环境应通过外部配置覆盖开发默认值。

