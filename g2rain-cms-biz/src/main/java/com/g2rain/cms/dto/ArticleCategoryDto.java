package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
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
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleCategoryDto extends BaseDto {

    /**
     * 机构标识
     */
    private Long organId;

    /**
     * 空间标识
     */
    private Long spaceId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类编码
     */
    private String categoryCode;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    private String status;
}