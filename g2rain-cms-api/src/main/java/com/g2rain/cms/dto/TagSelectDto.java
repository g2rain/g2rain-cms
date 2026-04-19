package com.g2rain.cms.dto;

import com.g2rain.common.model.BaseSelectListDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 标签表查询入参DTO
 * 用于TagDao.selectList方法的条件筛选
 * 表名: tag
 *
 * @author G2rain Generator
 */
@Schema(description = "标签表查询条件")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TagSelectDto extends BaseSelectListDto {

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
