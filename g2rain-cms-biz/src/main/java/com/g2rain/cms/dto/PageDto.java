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
 * 页面表查询DTO
 * 表名: page
 *
 * @author G2rain Generator
 */
@Schema(description = "页面表业务DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageDto extends BaseDto {

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "空间标识")
    @NotNull(message = "空间标识不能为空")
    private Long spaceId;

    @Schema(description = "页面名称")
    @NotBlank(message = "页面名称不能为空")
    @Size(max = 128, message = "页面名称长度不能超过128")
    private String pageName;

    @Schema(description = "页面编码")
    @Size(max = 64, message = "页面编码长度不能超过64")
    private String pageCode;

    @Schema(description = "访问路径")
    @Size(max = 255, message = "访问路径长度不能超过255")
    private String path;

    @Schema(description = "内容类型[MARKDOWN:Markdown, HTML:HTML]")
    @Size(max = 32, message = "内容类型长度不能超过32")
    private String contentType;

    @Schema(description = "状态[DRAFT:草稿, PUBLISHED:发布]")
    @Size(max = 32, message = "状态长度不能超过32")
    private String status;

    @Schema(description = "页面内容")
    private String content;
}
