package com.g2rain.cms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 根据文章ID列表查询标签条件入参DTO
 *
 * <p>供 {@code TagApi#selectTagsByArticleIds(TagSelectByArticleIdsDto)} 使用。</p>
 */
@Schema(description = "根据文章ID列表查询标签条件")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class TagSelectByArticleIdsDto {

    /**
     * 文章标识列表
     */
    @Schema(description = "文章标识列表")
    private List<Long> articleIds;
}

