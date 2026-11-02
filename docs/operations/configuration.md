# 配置

## 基础运行

| 配置 | 作用 |
| --- | --- |
| `SERVER_PORT` | HTTP 端口，默认 8080 |
| `SPRING_PROFILES_ACTIVE` | Spring Profile，默认 `dev` |
| `spring.application.name` | 服务名，当前为 `g2rain-cms` |
| `spring.threads.virtual.enabled` | 启用虚拟线程 |
| Servlet multipart | 上传大小限制 |

## 平台与数据

| 类别 | 配置 |
| --- | --- |
| Nacos | 服务地址、用户名、密码、namespace、group、服务名、配置文件扩展名与刷新 |
| MySQL | host、port、database、username、password |
| MyBatis | Mapper 路径、下划线映射、缓存和空值 JDBC 类型 |
| 数据隔离 | `g2rain.data.isolation.enabled` |
| Web 安全 | 登录守卫、身份参数注入、异常 JSON 与 Result 包装开关 |
| 文档与运维 | SpringDoc 路径、Swagger UI 和 Actuator 暴露项 |

仓库开发配置包含方便本地运行的凭据默认值。生产环境必须通过 Secret/环境或配置中心注入，不能沿用仓库默认值，也不要在日志和文档中复制实际凭据。

