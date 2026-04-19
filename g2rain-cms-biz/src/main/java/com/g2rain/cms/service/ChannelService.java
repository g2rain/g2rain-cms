package com.g2rain.cms.service;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.cms.dto.ChannelDto;
import com.g2rain.cms.dto.ChannelSelectDto;
import com.g2rain.cms.vo.ChannelVo;

import java.util.List;

/**
 * 栏目表服务接口
 * 表名: channel
 *
 * @author G2rain Generator
 */
public interface ChannelService {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return VO对象列表
     */
    List<ChannelVo> selectList(ChannelSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页VO数据
     */
    PageData<ChannelVo> selectPage(PageSelectListDto<ChannelSelectDto> selectDto);

    /**
     * 新增或更新数据
     *
     * @param dto 数据传输对象
     * @return 操作结果（影响行数）
     */
    Long save(ChannelDto dto);

    /**
     * 根据ID删除数据
     *
     * @param id 主键ID
     * @return 操作结果（影响行数）
     */
    int delete(Long id);
}