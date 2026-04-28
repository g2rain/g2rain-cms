package com.g2rain.cms.vo;

import com.g2rain.common.json.AdminCompanyCondition;
import com.g2rain.common.json.ConditionalJsonIgnore;
import com.g2rain.common.model.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章表返回VO
 * 关联表名: article
 * 功能：封装接口返回数据，继承BaseVo复用基础字段逻辑，隔离数据库实体与前端展示层
 *
 * @author G2rain Generator
 */
@Schema(description = "文章表返回")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleVo extends BaseVo {

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
     * 分类标识
     */
    @Schema(description = "分类标识")
    private Long categoryId;

    /**
     * 来源应用标识
     */
    @Schema(description = "来源应用标识")
    private Long sourceApplicationId;

    /**
     * 来源追踪ID
     */
    @Schema(description = "来源追踪ID")
    private String sourceTraceId;

    /**
     * 标题
     */
    @Schema(description = "标题")
    private String title;

    /**
     * 摘要
     */
    @Schema(description = "摘要")
    private String summary;

    /**
     * 封面
     */
    @Schema(description = "封面")
    private String cover;

    /**
     * 内容类型[MARKDOWN:Markdown, HTML:HTML]
     */
    @Schema(description = "内容类型[MARKDOWN:Markdown, HTML:HTML]")
    private String contentType;

    /**
     * 作者
     */
    @Schema(description = "作者")
    private String author;

    /**
     * 状态[DRAFT:草稿, PUBLISHED:发布]
     */
    @Schema(description = "状态[DRAFT:草稿, PUBLISHED:发布]")
    private String status;

    /**
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    /**
     * 标签列表
     */
    @Schema(description = "标签列表")
    private List<TagVo> tags;

    /**
     * 删除标识
     */
    @Schema(description = "删除标识")
    @ConditionalJsonIgnore(adminCompany = AdminCompanyCondition.TRUE)
    private Boolean deleteFlag;
}
