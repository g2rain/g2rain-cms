package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.ArticleCategoryApi;
import com.g2rain.cms.dto.ArticleCategoryDto;
import com.g2rain.cms.dto.ArticleCategorySelectDto;
import com.g2rain.cms.service.ArticleCategoryService;
import com.g2rain.cms.vo.ArticleCategoryVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章分类表控制器
 * 表名: article_category
 *
 * @author G2rain Generator
 */
@RestController
@RequestMapping("/article_category")
public class ArticleCategoryController implements ArticleCategoryApi {

    @Resource(name = "articleCategoryServiceImpl")
    private ArticleCategoryService articleCategoryService;

    @Override
    public Result<List<ArticleCategoryVo>> selectList(ArticleCategorySelectDto selectDto) {
        return Result.success(articleCategoryService.selectList(selectDto));
    }

    @Override
    public Result<PageData<ArticleCategoryVo>> selectPage(PageSelectListDto<ArticleCategorySelectDto> selectDto) {
        return Result.successPage(articleCategoryService.selectPage(selectDto));
    }

    @PostMapping("/save")
    public Result<Long> save(@RequestBody ArticleCategoryDto dto) {
        return Result.success(articleCategoryService.save(dto));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.success(articleCategoryService.delete(id));
    }
}