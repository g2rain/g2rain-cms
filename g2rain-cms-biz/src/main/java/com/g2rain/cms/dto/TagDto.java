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
 * 标签表查询DTO
 * 表名: tag
 *
 * @author G2rain Generator
 */
@Schema(description = "标签表业务DTO")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TagDto extends BaseDto {

    @Schema(description = "机构标识")
    @NotNull(message = "机构标识不能为空")
    private Long organId;

    @Schema(description = "标签名称")
    @NotBlank(message = "标签名称不能为空")
    @Size(max = 128, message = "标签名称长度不能超过128")
    private String tagName;
}
