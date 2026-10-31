package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.g2rain.common.validation.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 128)
    @Schema(description = "站点名称（新增必填）")
    private String siteName;

    /**
     * 站点编码
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 64)
    @Schema(description = "站点编码（新增必填）")
    private String siteCode;

    /**
     * 站点域名（多个用逗号分隔）
     */
    @Size(max = 255)
    @Schema(description = "站点域名（多个用逗号分隔）")
    private String domain;

    /**
     * 站点描述
     */
    @Size(max = 512)
    @Schema(description = "站点描述")
    private String description;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    @Size(max = 32)
    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    private String status;
}