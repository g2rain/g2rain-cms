package com.g2rain.cms.dao.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 联表查询结果承接：
 * <p>
 * article_tag_relation.article_id + tag(*) 的组合结果，用于一次性获取
 * “每个文章对应的 tag 列表”。
 * </p>
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TagWithArticleIdPo extends TagPo {

    /**
     * 文章标识
     */
    private Long articleId;
}

