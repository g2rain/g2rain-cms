package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 文章标签关系表查询DTO
 * 表名: article_tag_relation
 *
 * @author G2rain Generator
 */
@Schema(description = "文章标签关系表业务DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTagRelationDto extends BaseDto {

    @Schema(description = "文章标识")
    @NotNull(message = "文章标识不能为空")
    private Long articleId;

    @Schema(description = "标签标识")
    @NotNull(message = "标签标识不能为空")
    private Long tagId;
}
