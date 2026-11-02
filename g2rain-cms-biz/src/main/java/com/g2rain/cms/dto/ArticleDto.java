package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;
import com.g2rain.common.validation.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 文章表查询DTO
 * 表名: article
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(description = "文章表 DTO")
public class ArticleDto extends BaseDto {

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
     * 分类标识
     */
    @NotNull(groups = CreateGroup.class)
    @Schema(description = "分类标识（新增必填）")
    private Long categoryId;

    /**
     * 来源应用标识
     */
    @Schema(description = "来源应用标识")
    private Long sourceApplicationId;

    /**
     * 来源追踪ID
     */
    @Size(max = 128)
    @Schema(description = "来源追踪ID")
    private String sourceTraceId;

    /**
     * 标题
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 255)
    @Schema(description = "标题（新增必填）")
    private String title;

    /**
     * 摘要
     */
    @Size(max = 512)
    @Schema(description = "摘要")
    private String summary;

    /**
     * 封面
     */
    @Size(max = 255)
    @Schema(description = "封面")
    private String cover;

    /**
     * 内容类型[MARKDOWN:Markdown, HTML:HTML]
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 32)
    @Schema(description = "内容类型[MARKDOWN:Markdown, HTML:HTML]（新增必填）")
    private String contentType;

    /**
     * 作者
     */
    @Size(max = 128)
    @Schema(description = "作者")
    private String author;

    /**
     * 状态[DRAFT:草稿, PUBLISHED:发布]
     */
    @Size(max = 32)
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