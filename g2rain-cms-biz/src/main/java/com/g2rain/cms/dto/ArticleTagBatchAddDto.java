package com.g2rain.cms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 单文章批量添加标签请求DTO
 *
 * @author G2rain Generator
 */
@Schema(description = "单文章批量添加标签请求")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ArticleTagBatchAddDto {

    /**
     * 文章标识
     */
    @Schema(description = "文章标识")
    private Long articleId;

    /**
     * 标签标识列表
     */
    @Schema(description = "标签标识列表")
    private List<Long> tagIds;
}

