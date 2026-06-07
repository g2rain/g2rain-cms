package com.g2rain.cms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 栏目状态变更DTO
 */
@Schema(description = "栏目状态变更DTO")
@Setter
@Getter
@NoArgsConstructor
public class ChannelUpdateStatusDto {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;

    /**
     * 状态[ACTIVE:启用, INACTIVE:禁用]
     */
    @Schema(description = "状态[ACTIVE:启用, INACTIVE:禁用]")
    private String status;
}
