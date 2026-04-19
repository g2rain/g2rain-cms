package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
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

    /**
     * 机构标识
     */
    @Schema(description = "机构标识")
    private Long organId;

    /**
     * 标签名称
     */
    @Schema(description = "标签名称")
    private String tagName;
}
