package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.ArticleTagRelationApi;
import com.g2rain.cms.dto.ArticleTagBatchAddDto;
import com.g2rain.cms.dto.ArticleTagRelationDto;
import com.g2rain.cms.dto.ArticleTagRelationSelectDto;
import com.g2rain.cms.service.ArticleTagRelationService;
import com.g2rain.cms.vo.ArticleTagRelationVo;
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
 * 文章标签关系表控制器
 * 表名: article_tag_relation
 *
 * @author G2rain Generator
 */
@Tag(name = "文章标签关系")
@RestController
@RequestMapping("/article_tag_relation")
public class ArticleTagRelationController implements ArticleTagRelationApi {

    @Resource(name = "articleTagRelationServiceImpl")
    private ArticleTagRelationService articleTagRelationService;

    @Override
    @Operation(summary = "文章标签关系列表查询")
    public Result<List<ArticleTagRelationVo>> selectList(ArticleTagRelationSelectDto selectDto) {
        return Result.success(articleTagRelationService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "文章标签关系分页查询")
    public Result<PageData<ArticleTagRelationVo>> selectPage(PageSelectListDto<ArticleTagRelationSelectDto> selectDto) {
        return Result.successPage(articleTagRelationService.selectPage(selectDto));
    }

    @PostMapping("/batch_add_tags")
    @Operation(summary = "单文章批量添加标签关系")
    public Result<Integer> batchAddTags(@RequestBody ArticleTagBatchAddDto dto) {
        return Result.success(articleTagRelationService.batchAddTags(dto));
    }

    @PostMapping("/save")
    @Operation(summary = "文章标签关系保存")
    public Result<Long> save(@RequestBody ArticleTagRelationDto dto) {
        return Result.success(articleTagRelationService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "文章标签关系删除")
    public Result<Integer> delete(@Parameter(description = "主键") @PathVariable Long id) {
        return Result.success(articleTagRelationService.delete(id));
    }
}