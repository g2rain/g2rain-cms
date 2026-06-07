package com.g2rain.cms.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.g2rain.common.model.BaseSelectListDto;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * 文章分类表查询入参DTO
 * 用于ArticleCategoryDao.selectList方法的条件筛选
 * 表名: article_category
 *
 * @author G2rain Generator
 */
@Schema(description = "文章分类表查询条件")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleCategorySelectDto extends BaseSelectListDto {

    /**
     * 机构标识
     */
    @Schema(description = "机构标识")
    private Long organId;

    /**
     * 空间标识
     */
    @Schema(description = "空间标识")
    private Long spaceId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String categoryName;

    /**
     * 分类编码
     */
    @Schema(description = "分类编码")
    private String categoryCode;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    private String status;
}