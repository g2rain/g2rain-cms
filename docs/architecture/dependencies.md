# 依赖与协作

## 内部方向

- `startup → biz → api` 是唯一模块依赖方向。
- `Controller → Service → DAO/Mapper` 是主要调用方向。
- Converter 只进行对象转换，不访问数据库或网络。

## 平台协作

| 组件 | 关系 |
| --- | --- |
| `g2rain-cms-app` | 提供 CMS 管理页面和用户交互 |
| Gateway | 接收 App Token，执行统一鉴权并转发到 CMS |
| IAM | 为前端提供认证、授权和 Token |
| `g2rain-common` | 提供统一 Result、PageData、基础 DTO/VO、断言、时间和 ID 抽象 |
| MyBatis Extensions | 提供分页与数据隔离能力 |
| Nacos | 服务发现与配置导入 |
| MySQL | CMS 领域数据持久化 |
| Redis | 由数据/安全 Starter 提供运行时缓存能力 |

API 模块的查询契约可供受信后端模块复用；宽泛写入接口不应作为跨服务远程数据库使用。

