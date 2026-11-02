package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.g2rain.common.validation.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

    /**
     * 机构标识
     */
    @Schema(description = "机构标识")
    private Long organId;

    /**
     * 空间名称
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 128)
    @Schema(description = "空间名称（新增必填）")
    private String spaceName;

    /**
     * 空间编码
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 64)
    @Schema(description = "空间编码（新增必填）")
    private String spaceCode;

    /**
     * 空间类型[WEBSITE:官网, KNOWLEDGE:知识库, INTERNAL:内部]
     */
    @NotBlank(groups = CreateGroup.class)
    @Size(max = 32)
    @Schema(description = "空间类型[WEBSITE:官网, KNOWLEDGE:知识库, INTERNAL:内部]（新增必填）")
    private String spaceType;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    @Size(max = 32)
    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    private String status;
}
