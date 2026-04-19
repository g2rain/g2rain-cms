package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 文章分类表返回Po
 * 关联表名: article_category
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleCategoryPo extends BasePo {

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

    /**
     * 删除标识[0:未删除, 1:已删除]
     */
    private Boolean deleteFlag;
}