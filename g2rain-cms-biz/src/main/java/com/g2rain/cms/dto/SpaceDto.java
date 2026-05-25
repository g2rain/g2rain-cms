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
 * 内容空间表查询DTO
 * 表名: space
 *
 * @author G2rain Generator
 */
@Schema(description = "内容空间表业务DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SpaceDto extends BaseDto {

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "空间名称")
    @NotBlank(message = "空间名称不能为空")
    @Size(max = 128, message = "空间名称长度不能超过128")
    private String spaceName;

    @Schema(description = "空间编码")
    @NotBlank(message = "空间编码不能为空")
    @Size(max = 64, message = "空间编码长度不能超过64")
    private String spaceCode;

    @Schema(description = "空间类型[WEBSITE:官网, KNOWLEDGE:知识库, INTERNAL:内部]")
    @NotBlank(message = "空间类型不能为空")
    @Size(max = 32, message = "空间类型长度不能超过32")
    private String spaceType;

    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    @Size(max = 32, message = "状态长度不能超过32")
    private String status;
}
