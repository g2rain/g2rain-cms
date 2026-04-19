package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 栏目表查询DTO
 * 表名: channel
 *
 * @author G2rain Generator
 */
@Schema(description = "栏目表业务DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChannelDto extends BaseDto {

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
     * 站点标识
     */
    @Schema(description = "站点标识")
    private Long siteId;

    /**
     * 父栏目标识
     */
    @Schema(description = "父栏目标识")
    private Long parentId;

    /**
     * 栏目名称
     */
    @Schema(description = "栏目名称")
    private String channelName;

    /**
     * 栏目编码
     */
    @Schema(description = "栏目编码")
    private String channelCode;

    /**
     * 栏目类型[LIST:列表, PAGE:页面, LINK:外链]
     */
    @Schema(description = "栏目类型[LIST:列表, PAGE:页面, LINK:外链]")
    private String channelType;

    /**
     * 访问路径
     */
    @Schema(description = "访问路径")
    private String path;

    /**
     * 分类标识
     */
    @Schema(description = "分类标识")
    private Long categoryId;

    /**
     * 页面标识
     */
    @Schema(description = "页面标识")
    private Long pageId;

    /**
     * 外链URL
     */
    @Schema(description = "外链URL")
    private String linkUrl;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sortOrder;

    /**
     * 是否显示[0:否, 1:是]
     */
    @Schema(description = "是否显示[0:否, 1:是]")
    private Byte visible;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private String status;
}
