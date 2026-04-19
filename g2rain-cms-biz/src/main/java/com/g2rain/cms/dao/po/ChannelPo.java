package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 栏目表返回Po
 * 关联表名: channel
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChannelPo extends BasePo {

    /**
     * 机构标识
     */
    private Long organId;

    /**
     * 空间标识
     */
    private Long spaceId;

    /**
     * 站点标识
     */
    private Long siteId;

    /**
     * 父栏目标识
     */
    private Long parentId;

    /**
     * 栏目名称
     */
    private String channelName;

    /**
     * 栏目编码
     */
    private String channelCode;

    /**
     * 栏目类型[LIST:列表, PAGE:页面, LINK:外链]
     */
    private String channelType;

    /**
     * 访问路径
     */
    private String path;

    /**
     * 分类标识
     */
    private Long categoryId;

    /**
     * 页面标识
     */
    private Long pageId;

    /**
     * 外链URL
     */
    private String linkUrl;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 是否显示[0:否, 1:是]
     */
    private Byte visible;

    /**
     * 状态
     */
    private String status;

    /**
     * 删除标识
     */
    private Boolean deleteFlag;
}