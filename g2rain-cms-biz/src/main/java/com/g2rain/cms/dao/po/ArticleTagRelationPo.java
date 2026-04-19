package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 文章标签关系表返回Po
 * 关联表名: article_tag_relation
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTagRelationPo extends BasePo {

    /**
     * 文章标识
     */
    private Long articleId;

    /**
     * 标签标识
     */
    private Long tagId;

    /**
     * 删除标识
     */
    private Boolean deleteFlag;
}