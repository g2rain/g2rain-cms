package com.g2rain.cms.service;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.cms.dto.TagDto;
import com.g2rain.cms.dto.TagSelectDto;
import com.g2rain.cms.dto.TagSelectByArticleIdsDto;
import com.g2rain.cms.vo.TagVo;

import java.util.Map;
import java.util.List;

/**
 * 标签表服务接口
 * 表名: tag
 *
 * @author G2rain Generator
 */
public interface TagService {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return VO对象列表
     */
    List<TagVo> selectList(TagSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页VO数据
     */
    PageData<TagVo> selectPage(PageSelectListDto<TagSelectDto> selectDto);

    /**
     * 根据文章ID列表查询每篇文章对应的tag列表
     *
     * @param request articleIds 列表
     * @return Map(ArticleId -> TagVo列表)
     */
    Map<Long, List<TagVo>> selectTagsByArticleIds(TagSelectByArticleIdsDto request);

    /**
     * 新增或更新数据
     *
     * @param dto 数据传输对象
     * @return 操作结果（影响行数）
     */
    Long save(TagDto dto);

    /**
     * 根据ID删除数据
     *
     * @param id 主键ID
     * @return 操作结果（影响行数）
     */
    int delete(Long id);
}