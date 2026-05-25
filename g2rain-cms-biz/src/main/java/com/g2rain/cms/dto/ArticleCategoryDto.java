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
 * 文章分类表查询DTO
 * 表名: article_category
 *
 * @author G2rain Generator
 */
@Schema(description = "文章分类表业务 DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleCategoryDto extends BaseDto {

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "空间标识")
    @NotNull(message = "空间标识不能为空")
    private Long spaceId;

    @Schema(description = "分类名称")
    @NotBlank(message = "分类名称不能为空")
    @Size(max = 128, message = "分类名称长度不能超过128")
    private String categoryName;

    @Schema(description = "分类编码")
    @Size(max = 64, message = "分类编码长度不能超过64")
    private String categoryCode;

    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    @Size(max = 32, message = "状态长度不能超过32")
    private String status;
}
