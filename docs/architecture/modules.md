# 模块职责

```text
g2rain-cms-startup → g2rain-cms-biz → g2rain-cms-api
```

| 模块 | 职责 | 当前内容 |
| --- | --- | --- |
| `g2rain-cms-api` | 可复用查询契约 | 8 组查询 API、SelectDto、VO，以及按文章批量查询标签契约 |
| `g2rain-cms-biz` | 领域实现 | 8 组 Controller/Service/DAO/Mapper、写入 DTO、MapStruct Converter |
| `g2rain-cms-startup` | 运行时组装 | `com.g2rain.Application`、Web/Actuator、Nacos、配置和 Jib 镜像 |

API 不依赖 Biz/Startup；Biz 依赖 API；Startup 依赖 Biz。Controller 负责协议适配，Service 负责用例与事务，DAO/Mapper 只负责持久化。

