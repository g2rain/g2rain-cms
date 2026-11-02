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

    /**
     * 机构标识
     */
    @Schema(description = "机构标识")
    private Long organId;

    /**
     * 空间标识
     */
    @NotNull(groups = CreateGroup.class)
    @Schema(description = "空间标识（新增必填）")
    private Long spaceId;

    /**
     * 分类名称
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 128)
    @Schema(description = "分类名称（新增必填）")
    private String categoryName;

    /**
     * 分类编码
     */
    @Size(max = 64)
    @Schema(description = "分类编码")
    private String categoryCode;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    @Size(max = 32)
    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    private String status;
}