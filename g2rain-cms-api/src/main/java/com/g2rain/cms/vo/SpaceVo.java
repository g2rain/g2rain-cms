package com.g2rain.cms.vo;

import com.g2rain.common.json.AdminCompanyCondition;
import com.g2rain.common.json.ConditionalJsonIgnore;
import com.g2rain.common.model.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 内容空间表返回VO
 * 关联表名: space
 * 功能：封装接口返回数据，继承BaseVo复用基础字段逻辑，隔离数据库实体与前端展示层
 *
 * @author G2rain Generator
 */
@Schema(description = "内容空间表返回")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SpaceVo extends BaseVo {

    /**
     * 机构标识
     */
    @Schema(description = "机构标识")
    private Long organId;

    /**
     * 空间名称
     */
    @Schema(description = "空间名称")
    private String spaceName;

    /**
     * 空间编码
     */
    @Schema(description = "空间编码")
    private String spaceCode;

    /**
     * 空间类型[WEBSITE:官网, KNOWLEDGE:知识库, INTERNAL:内部]
     */
    @Schema(description = "空间类型[WEBSITE:官网, KNOWLEDGE:知识库, INTERNAL:内部]")
    private String spaceType;

    /**
     * 状态[ENABLED:启用, DISABLED:禁用]
     */
    @Schema(description = "状态[ENABLED:启用, DISABLED:禁用]")
    private String status;

    /**
     * 删除标识[0:未删除, 1:已删除]
     */
    @Schema(description = "删除标识[0:未删除, 1:已删除]")
    @ConditionalJsonIgnore(adminCompany = AdminCompanyCondition.TRUE)
    private Boolean deleteFlag;
}
