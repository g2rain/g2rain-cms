package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.ArticleCategorySelectDto;
import com.g2rain.cms.vo.ArticleCategoryVo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 文章分类表API接口
 * 表名: article_category
 *
 * @author G2rain Generator
 */
public interface ArticleCategoryApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    Result<List<ArticleCategoryVo>> selectList(ArticleCategorySelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    Result<PageData<ArticleCategoryVo>> selectPage(PageSelectListDto<ArticleCategorySelectDto> selectDto);
}