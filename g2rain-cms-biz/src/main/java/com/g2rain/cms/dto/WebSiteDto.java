package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 站点表查询DTO
 * 表名: web_site
 *
 * @author G2rain Generator
 */
@Schema(description = "站点表业务 DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebSiteDto extends BaseDto {

    /**
     * 机构标识
     */
    @Schema(description = "机构标识")
    private Long organId;

    /**
     * 站点名称
     */
    @Schema(description = "站点名称")
    private String siteName;

    /**
     * 站点编码
     */
    @Schema(description = "站点编码")
    private String siteCode;

    /**
     * 站点域名（多个用逗号分隔）
     */
    @Schema(description = "站点域名（多个用逗号分隔）")
    private String domain;

    /**
     * 站点描述
     */
    @Schema(description = "站点描述")
    private String description;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    private String status;
}