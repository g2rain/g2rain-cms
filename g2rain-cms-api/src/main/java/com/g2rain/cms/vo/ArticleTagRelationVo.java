package com.g2rain.cms.vo;

import com.g2rain.common.json.AdminCompanyCondition;
import com.g2rain.common.json.ConditionalJsonIgnore;
import com.g2rain.common.model.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 文章标签关系表返回VO
 * 关联表名: article_tag_relation
 * 功能：封装接口返回数据，继承BaseVo复用基础字段逻辑，隔离数据库实体与前端展示层
 *
 * @author G2rain Generator
 */
@Schema(description = "文章标签关系表返回")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTagRelationVo extends BaseVo {

    /**
     * 文章标识
     */
    @Schema(description = "文章标识")
    private Long articleId;

    /**
     * 标签标识
     */
    @Schema(description = "标签标识")
    private Long tagId;

    /**
     * 删除标识
     */
    @Schema(description = "删除标识")
    @ConditionalJsonIgnore(adminCompany = AdminCompanyCondition.TRUE)
    private Boolean deleteFlag;
}
