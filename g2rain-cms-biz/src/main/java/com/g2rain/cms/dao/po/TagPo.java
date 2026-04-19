package com.g2rain.cms.dao.po;

import com.g2rain.common.model.BasePo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 标签表返回Po
 * 关联表名: tag
 * 功能：封装实体数据，继承BasePo复用基础字段逻辑
 *
 * @author G2rain Generator
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TagPo extends BasePo {

    /**
     * 机构标识
     */
    private Long organId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 删除标识
     */
    private Boolean deleteFlag;
}