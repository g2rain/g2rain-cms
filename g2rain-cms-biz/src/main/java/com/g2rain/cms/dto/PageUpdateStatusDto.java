package com.g2rain.cms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 页面状态变更DTO
 */
@Schema(description = "页面状态变更DTO")
@Setter
@Getter
@NoArgsConstructor
public class PageUpdateStatusDto {

    /**
     * 主键ID
     */
    @NotNull
    @Schema(description = "主键ID")
    private Long id;

    /**
     * 状态[DRAFT:草稿, PUBLISHED:发布]
     */
    @NotBlank
    @Size(max = 32)
    @Schema(description = "状态[DRAFT:草稿, PUBLISHED:发布]")
    private String status;
}
