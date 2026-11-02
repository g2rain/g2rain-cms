package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.g2rain.common.validation.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    /**
     * 文章标识
     */
    @NotNull(groups = CreateGroup.class)
    @Schema(description = "文章标识（新增必填）")
    private Long articleId;

    /**
     * 标签标识
     */
    @NotNull(groups = CreateGroup.class)
    @Schema(description = "标签标识（新增必填）")
    private Long tagId;
}
