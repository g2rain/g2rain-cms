package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseSelectListDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 页面表查询入参DTO
 * 用于PageDao.selectList方法的条件筛选
 * 表名: page
 *
 * @author G2rain Generator
 */
@Schema(description = "页面表查询条件")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageSelectDto extends BaseSelectListDto {

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
     * 页面名称
     */
    @Schema(description = "页面名称")
    private String pageName;

    /**
     * 页面编码
     */
    @Schema(description = "页面编码")
    private String pageCode;

    /**
     * 访问路径
     */
    @Schema(description = "访问路径")
    private String path;

    /**
     * md:markdown格式, html:网页
     */
    @Schema(description = "内容类型[MARKDOWN:Markdown, HTML:HTML]")
    private String contentType;

    /**
     * 状态[DRAFT:草稿, PUBLISHED:发布]
     */
    @Schema(description = "状态[DRAFT:草稿, PUBLISHED:发布]")
    private String status;

    /**
     * 页面内容
     */
    @Schema(description = "页面内容")
    private String content;
}
