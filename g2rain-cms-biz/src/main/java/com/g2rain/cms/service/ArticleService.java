package com.g2rain.cms.service;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.cms.dto.ArticleDto;
import com.g2rain.cms.dto.ArticleSelectDto;
import com.g2rain.cms.vo.ArticleDetailVo;
import com.g2rain.cms.vo.ArticleVo;

import java.util.List;

/**
 * 文章表服务接口
 * 表名: article
 *
 * @author G2rain Generator
 */
public interface ArticleService {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return VO对象列表
     */
    List<ArticleVo> selectList(ArticleSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页VO数据
     */
    PageData<ArticleVo> selectPage(PageSelectListDto<ArticleSelectDto> selectDto);

    /**
     * 根据ID查询文章详情（包含内容）
     *
     * @param id 主键ID
     * @return 详情VO
     */
    ArticleDetailVo detail(Long id);

    /**
     * 新增或更新数据
     *
     * @param dto 数据传输对象
     * @return 操作结果（影响行数）
     */
    Long save(ArticleDto dto);

    /**
     * 根据ID删除数据
     *
     * @param id 主键ID
     * @return 操作结果（影响行数）
     */
    int delete(Long id);
}