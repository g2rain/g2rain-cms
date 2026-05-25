package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 文章表查询DTO
 * 表名: article
 *
 * @author G2rain Generator
 */
@Schema(description = "文章表业务DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleDto extends BaseDto {

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "空间标识")
    @NotNull(message = "空间标识不能为空")
    private Long spaceId;

    @Schema(description = "分类标识")
    @NotNull(message = "分类标识不能为空")
    private Long categoryId;

    @Schema(description = "来源应用标识")
    private Long sourceApplicationId;

    @Schema(description = "来源追踪ID")
    @Size(max = 128, message = "来源追踪ID长度不能超过128")
    private String sourceTraceId;

    @Schema(description = "标题")
    @NotBlank(message = "标题不能为空")
    @Size(max = 255, message = "标题长度不能超过255")
    private String title;

    @Schema(description = "摘要")
    @Size(max = 512, message = "摘要长度不能超过512")
    private String summary;

    @Schema(description = "封面")
    @Size(max = 255, message = "封面长度不能超过255")
    private String cover;

    @Schema(description = "内容类型[MARKDOWN:Markdown, HTML:HTML]")
    @NotBlank(message = "内容类型不能为空")
    @Size(max = 32, message = "内容类型长度不能超过32")
    private String contentType;

    @Schema(description = "作者")
    @Size(max = 128, message = "作者长度不能超过128")
    private String author;

    @Schema(description = "状态[DRAFT:草稿, PUBLISHED:发布]")
    @Size(max = 32, message = "状态长度不能超过32")
    private String status;

    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    @Schema(description = "内容")
    private String content;
}
