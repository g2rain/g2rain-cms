package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 站点表返回Po
 * 关联表名: web_site
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebSitePo extends BasePo {

    /**
     * 机构标识
     */
    private Long organId;

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 站点编码
     */
    private String siteCode;

    /**
     * 站点域名（多个用逗号分隔）
     */
    private String domain;

    /**
     * 站点描述
     */
    private String description;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    private String status;

    /**
     * 删除标识[0:未删除, 1:已删除]
     */
    private Boolean deleteFlag;
}