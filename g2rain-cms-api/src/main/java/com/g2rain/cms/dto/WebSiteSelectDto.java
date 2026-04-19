package com.g2rain.cms.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.g2rain.common.model.BaseSelectListDto;


/**
 * 站点表查询入参DTO
 * 用于WebSiteDao.selectList方法的条件筛选
 * 表名: web_site
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebSiteSelectDto extends BaseSelectListDto {

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
}