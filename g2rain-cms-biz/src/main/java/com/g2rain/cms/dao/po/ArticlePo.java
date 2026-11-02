package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * 文章表返回Po
 * 关联表名: article
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticlePo extends BasePo {

    /**
     * 机构标识
     */
    private Long organId;

    /**
     * 空间标识
     */
    private Long spaceId;

    /**
     * 分类标识
     */
    private Long categoryId;

    /**
     * 来源应用标识
     */
    private Long sourceApplicationId;

    /**
     * 来源追踪ID
     */
    private String sourceTraceId;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 封面
     */
    private String cover;

    /**
     * 内容类型[MARKDOWN:Markdown, HTML:HTML]
     */
    private String contentType;

    /**
     * 作者
     */
    private String author;

    /**
     * 状态[DRAFT:草稿, PUBLISHED:发布]
     */
    private String status;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 删除标识
     */
    private Boolean deleteFlag;
}