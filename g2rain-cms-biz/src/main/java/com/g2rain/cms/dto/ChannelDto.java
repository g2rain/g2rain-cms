package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "空间标识")
    @NotNull(message = "空间标识不能为空")
    private Long spaceId;

    @Schema(description = "站点标识")
    @NotNull(message = "站点标识不能为空")
    private Long siteId;

    @Schema(description = "父栏目标识")
    private Long parentId;

    @Schema(description = "栏目名称")
    @NotBlank(message = "栏目名称不能为空")
    @Size(max = 128, message = "栏目名称长度不能超过128")
    private String channelName;

    @Schema(description = "栏目编码")
    @Size(max = 64, message = "栏目编码长度不能超过64")
    private String channelCode;

    @Schema(description = "栏目类型[LIST:列表, PAGE:页面, LINK:外链]")
    @NotBlank(message = "栏目类型不能为空")
    @Size(max = 32, message = "栏目类型长度不能超过32")
    private String channelType;

    @Schema(description = "访问路径")
    @Size(max = 255, message = "访问路径长度不能超过255")
    private String path;

    @Schema(description = "分类标识")
    private Long categoryId;

    @Schema(description = "页面标识")
    private Long pageId;

    @Schema(description = "外链URL")
    @Size(max = 255, message = "外链URL长度不能超过255")
    private String linkUrl;

    @Schema(description = "排序")
    private Integer sortOrder;

    @Schema(description = "是否显示[0:否, 1:是]")
    private Byte visible;

    @Schema(description = "状态")
    @Size(max = 32, message = "状态长度不能超过32")
    private String status;
}
