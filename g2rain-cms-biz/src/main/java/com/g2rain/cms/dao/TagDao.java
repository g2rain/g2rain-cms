package com.g2rain.cms.dao;

import com.g2rain.cms.dao.po.TagPo;
import com.g2rain.cms.dao.po.TagWithArticleIdPo;
import com.g2rain.cms.dto.TagSelectDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 标签表数据访问接口
 * 表名: tag
 *
 * @author G2rain Generator
 */
@Mapper
public interface TagDao {

    /**
     * 插入单条记录
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(TagPo entity);

    /**
     * 批量插入记录
     *
     * @param list 实体对象列表
     * @return 影响行数
     */
    int insertMultiple(List<TagPo> list);

    /**
     * 根据ID更新记录
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(TagPo entity);

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
    int updateByVersion(TagPo entity);

    /**
     * 根据ID查询记录
     *
     * @param id 主键ID
     * @return 实体对象
     */
    TagPo selectById(Long id);

    /**
     * 根据查询入参DTO筛选列表
     *
     * @param selectDto 查询条件DTO
     * @return 实体对象列表
     */
    List<TagPo> selectList(TagSelectDto selectDto);

    /**
     * 联表查询：根据 articleId 列表批量获取每个文章对应的 tag
     *
     * @param articleIds 文章ID列表
     * @return 文章ID + tag 信息组合结果
     */
    List<TagWithArticleIdPo> selectTagsByArticleIds(List<Long> articleIds);
}