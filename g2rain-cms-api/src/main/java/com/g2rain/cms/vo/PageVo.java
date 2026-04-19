package com.g2rain.cms.vo;

import com.g2rain.common.json.AdminCompanyCondition;
import com.g2rain.common.json.ConditionalJsonIgnore;
import com.g2rain.common.model.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 页面表返回VO
 * 关联表名: page
 * 功能：封装接口返回数据，继承BaseVo复用基础字段逻辑，隔离数据库实体与前端展示层
 *
 * @author G2rain Generator
 */
@Schema(description = "页面表返回")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageVo extends BaseVo {

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

    /**
     * 删除标识
     */
    @Schema(description = "删除标识")
    @ConditionalJsonIgnore(adminCompany = AdminCompanyCondition.TRUE)
    private Boolean deleteFlag;
}
