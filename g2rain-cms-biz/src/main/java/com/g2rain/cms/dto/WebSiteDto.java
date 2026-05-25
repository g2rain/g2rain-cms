package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "站点名称")
    @NotBlank(message = "站点名称不能为空")
    @Size(max = 128, message = "站点名称长度不能超过128")
    private String siteName;

    @Schema(description = "站点编码")
    @NotBlank(message = "站点编码不能为空")
    @Size(max = 64, message = "站点编码长度不能超过64")
    private String siteCode;

    @Schema(description = "站点域名（多个用逗号分隔）")
    @Size(max = 255, message = "站点域名长度不能超过255")
    private String domain;

    @Schema(description = "站点描述")
    @Size(max = 512, message = "站点描述长度不能超过512")
    private String description;

    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    @Size(max = 32, message = "状态长度不能超过32")
    private String status;
}
