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
@RestController
@RequestMapping("/article")
public class ArticleController implements ArticleApi {

    @Resource(name = "articleServiceImpl")
    private ArticleService articleService;

    @Override
    public Result<List<ArticleVo>> selectList(ArticleSelectDto selectDto) {
        return Result.success(articleService.selectList(selectDto));
    }

    @Override
    public Result<PageData<ArticleVo>> selectPage(PageSelectListDto<ArticleSelectDto> selectDto) {
        return Result.successPage(articleService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新文章表信息", description = "新增或更新文章表基础信息")
    public Result<Long> save(@RequestBody ArticleDto dto) {
        return Result.success(articleService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除文章表记录", description = "根据主键删除文章表记录")
    public Result<Integer> delete(@Parameter(description = "文章表标识") @PathVariable Long id) {
        return Result.success(articleService.delete(id));
    }
}