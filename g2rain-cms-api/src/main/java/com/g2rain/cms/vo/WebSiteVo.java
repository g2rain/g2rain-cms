package com.g2rain.cms.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.g2rain.common.model.BaseVo;

import com.g2rain.common.json.ConditionalJsonIgnore;
import com.g2rain.common.json.AdminCompanyCondition;

/**
 * 站点表返回VO
 * 关联表名: web_site
 * 功能：封装接口返回数据，继承BaseVo复用基础字段逻辑，隔离数据库实体与前端展示层
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebSiteVo extends BaseVo {

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
    @ConditionalJsonIgnore(adminCompany = AdminCompanyCondition.TRUE)
    private Boolean deleteFlag;
}