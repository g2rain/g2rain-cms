package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 页面表返回Po
 * 关联表名: page
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagePo extends BasePo {

    /**
     * 机构标识
     */
    private Long organId;

    /**
     * 空间标识
     */
    private Long spaceId;

    /**
     * 页面名称
     */
    private String pageName;

    /**
     * 页面编码
     */
    private String pageCode;

    /**
     * 访问路径
     */
    private String path;

    /**
     * 内容类型 md:markdown格式, html:网页
     */
    private String contentType;

    /**
     * 状态[DRAFT:草稿, PUBLISHED:发布]
     */
    private String status;

    /**
     * 页面内容
     */
    private String content;

    /**
     * 删除标识
     */
    private Boolean deleteFlag;
}