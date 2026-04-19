package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseSelectListDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 文章表查询入参DTO
 * 用于ArticleDao.selectList方法的条件筛选
 * 表名: article
 *
 * @author G2rain Generator
 */
@Schema(description = "文章表查询条件")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleSelectDto extends BaseSelectListDto {

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
     * 内容
     */
    @Schema(description = "内容")
    private String content;
}
