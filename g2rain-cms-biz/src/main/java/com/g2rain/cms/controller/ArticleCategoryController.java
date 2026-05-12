package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.ArticleCategoryApi;
import com.g2rain.cms.dto.ArticleCategoryDto;
import com.g2rain.cms.dto.ArticleCategorySelectDto;
import com.g2rain.cms.service.ArticleCategoryService;
import com.g2rain.cms.vo.ArticleCategoryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "文章分类", description = "文章分类维护：查询、保存与删除")
@RestController
@RequestMapping("/article_category")
public class ArticleCategoryController implements ArticleCategoryApi {

    @Resource(name = "articleCategoryServiceImpl")
    private ArticleCategoryService articleCategoryService;

    @Override
    @Operation(summary = "查询文章分类列表", description = "按查询条件筛选文章分类，不分页返回列表")
    public Result<List<ArticleCategoryVo>> selectList(ArticleCategorySelectDto selectDto) {
        return Result.success(articleCategoryService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询文章分类", description = "按查询条件筛选文章分类并分页，含总数与当前页数据")
    public Result<PageData<ArticleCategoryVo>> selectPage(PageSelectListDto<ArticleCategorySelectDto> selectDto) {
        return Result.successPage(articleCategoryService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新文章分类", description = "根据请求体主键是否存在，新增或更新文章分类信息")
    public Result<Long> save(@RequestBody ArticleCategoryDto dto) {
        return Result.success(articleCategoryService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除文章分类", description = "根据主键删除文章分类记录")
    public Result<Integer> delete(@Parameter(description = "文章分类主键") @PathVariable Long id) {
        return Result.success(articleCategoryService.delete(id));
    }
}