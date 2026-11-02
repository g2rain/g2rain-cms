package com.g2rain.cms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    @NotNull
    @Schema(description = "主键ID（必填）")
    private Long id;

    /**
     * 状态[ACTIVE:启用, INACTIVE:禁用]
     */
    @NotBlank
    @Size(max = 32)
    @Schema(description = "状态[ACTIVE:启用, INACTIVE:禁用]（必填）")
    private String status;
}
