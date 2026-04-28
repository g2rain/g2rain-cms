package com.g2rain.cms.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 文章详情返回VO
 */
@Schema(description = "文章详情返回")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleDetailVo extends ArticleVo {

    /**
     * 内容
     */
    @Schema(description = "内容")
    private String content;
}
