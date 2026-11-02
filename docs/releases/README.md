# 发布记录

- [v1.0.0：CMS 首个稳定版与 GHCR 镜像发布准备](v1.0.0.md)

发布改动先通过 Pull Request 合入 `main` 并完成验证，再从该提交创建 `v<major>.<minor>.<patch>` tag。稳定版 tag 推送会触发 GHCR 镜像构建与发布；不会自动创建 GitHub Release 或部署服务。
