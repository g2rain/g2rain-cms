package com.g2rain.cms.dao;

import com.g2rain.cms.dao.po.SpacePo;
import com.g2rain.cms.dto.SpaceSelectDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 内容空间表数据访问接口
 * 表名: space
 *
 * @author G2rain Generator
 */
@Mapper
public interface SpaceDao {

    /**
     * 插入单条记录
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(SpacePo entity);

    /**
     * 批量插入记录
     *
     * @param list 实体对象列表
     * @return 影响行数
     */
    int insertMultiple(List<SpacePo> list);

    /**
     * 根据ID更新记录
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(SpacePo entity);

    /**
     * 根据ID删除记录
     *
     * @param id 主键ID
     * @return 影响行数
     */
    int delete(Long id);

    /**
     * 根据ID和Version更新记录（乐观锁更新）
     *
     * @param entity 实体对象（必须包含version字段）
     * @return 影响行数
     */
    int updateByVersion(SpacePo entity);

    /**
     * 根据ID查询记录
     *
     * @param id 主键ID
     * @return 实体对象
     */
    SpacePo selectById(Long id);

    /**
     * 根据查询入参DTO筛选列表
     *
     * @param selectDto 查询条件DTO
     * @return 实体对象列表
     */
    List<SpacePo> selectList(SpaceSelectDto selectDto);
}