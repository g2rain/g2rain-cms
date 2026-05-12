package com.g2rain.cms.service;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.cms.dto.SpaceDto;
import com.g2rain.cms.dto.SpaceSelectDto;
import com.g2rain.cms.dto.SpaceUpdateStatusDto;
import com.g2rain.cms.vo.SpaceVo;

import java.util.List;

/**
 * 内容空间表服务接口
 * 表名: space
 *
 * @author G2rain Generator
 */
public interface SpaceService {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return VO对象列表
     */
    List<SpaceVo> selectList(SpaceSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页VO数据
     */
    PageData<SpaceVo> selectPage(PageSelectListDto<SpaceSelectDto> selectDto);

    /**
     * 新增或更新数据
     *
     * @param dto 数据传输对象
     * @return 操作结果（影响行数）
     */
    Long save(SpaceDto dto);

    /**
     * 状态变更
     *
     * @param dto 需包含id与status
     * @return 操作结果（影响行数）
     */
    int updateStatus(SpaceUpdateStatusDto dto);

    /**
     * 根据ID删除数据
     *
     * @param id 主键ID
     * @return 操作结果（影响行数）
     */
    int delete(Long id);
}