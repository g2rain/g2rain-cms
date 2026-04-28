package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.ArticleApi;
import com.g2rain.cms.dto.ArticleDto;
import com.g2rain.cms.dto.ArticleSelectDto;
import com.g2rain.cms.service.ArticleService;
import com.g2rain.cms.vo.ArticleDetailVo;
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
@Tag(name = "文章")
@RestController
@RequestMapping("/article")
public class ArticleController implements ArticleApi {

    @Resource(name = "articleServiceImpl")
    private ArticleService articleService;

    @Override
    @Operation(summary = "文章列表查询")
    public Result<List<ArticleVo>> selectList(ArticleSelectDto selectDto) {
        return Result.success(articleService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "文章分页查询")
    public Result<PageData<ArticleVo>> selectPage(PageSelectListDto<ArticleSelectDto> selectDto) {
        return Result.successPage(articleService.selectPage(selectDto));
    }

    @Override
    @Operation(summary = "文章详情查询")
    public Result<ArticleDetailVo> detail(@PathVariable("id") Long id) {
        return Result.success(articleService.detail(id));
    }

    @PostMapping("/save")
    @Operation(summary = "文章保存")
    public Result<Long> save(@RequestBody ArticleDto dto) {
        return Result.success(articleService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "文章删除")
    public Result<Integer> delete(@Parameter(description = "主键") @PathVariable Long id) {
        return Result.success(articleService.delete(id));
    }
}