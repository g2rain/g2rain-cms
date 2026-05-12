package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.ArticleApi;
import com.g2rain.cms.dto.ArticleDto;
import com.g2rain.cms.dto.ArticleSelectDto;
import com.g2rain.cms.service.ArticleService;
import com.g2rain.cms.vo.ArticleVo;
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
 * 文章表控制器
 * 表名: article
 *
 * @author G2rain Generator
 */
@Tag(name = "文章", description = "文章内容：查询、保存与删除")
@RestController
@RequestMapping("/article")
public class ArticleController implements ArticleApi {

    @Resource(name = "articleServiceImpl")
    private ArticleService articleService;

    @Override
    @Operation(summary = "查询文章列表", description = "按查询条件筛选文章，不分页返回列表")
    public Result<List<ArticleVo>> selectList(ArticleSelectDto selectDto) {
        return Result.success(articleService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询文章", description = "按查询条件筛选文章并分页，含总数与当前页数据")
    public Result<PageData<ArticleVo>> selectPage(PageSelectListDto<ArticleSelectDto> selectDto) {
        return Result.successPage(articleService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新文章", description = "根据请求体主键是否存在，新增或更新文章信息")
    public Result<Long> save(@RequestBody ArticleDto dto) {
        return Result.success(articleService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除文章", description = "根据主键删除文章记录")
    public Result<Integer> delete(@Parameter(description = "文章主键") @PathVariable Long id) {
        return Result.success(articleService.delete(id));
    }
}