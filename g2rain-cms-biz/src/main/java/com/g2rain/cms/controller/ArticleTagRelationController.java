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
@Tag(name = "文章标签关系", description = "文章与标签关联：查询、批量打标、保存与删除")
@RestController
@RequestMapping("/article_tag_relation")
public class ArticleTagRelationController implements ArticleTagRelationApi {

    @Resource(name = "articleTagRelationServiceImpl")
    private ArticleTagRelationService articleTagRelationService;

    @Override
    @Operation(summary = "查询文章标签关系列表", description = "按查询条件筛选文章标签关系，不分页返回列表")
    public Result<List<ArticleTagRelationVo>> selectList(ArticleTagRelationSelectDto selectDto) {
        return Result.success(articleTagRelationService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询文章标签关系", description = "按查询条件筛选文章标签关系并分页，含总数与当前页数据")
    public Result<PageData<ArticleTagRelationVo>> selectPage(PageSelectListDto<ArticleTagRelationSelectDto> selectDto) {
        return Result.successPage(articleTagRelationService.selectPage(selectDto));
    }

    @PostMapping("/batch_add_tags")
    @Operation(summary = "单文章批量添加标签", description = "为指定文章一次性绑定多个标签关系")
    public Result<Integer> batchAddTags(@RequestBody ArticleTagBatchAddDto dto) {
        return Result.success(articleTagRelationService.batchAddTags(dto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新文章标签关系", description = "根据请求体主键是否存在，新增或更新单条文章标签关系")
    public Result<Long> save(@RequestBody ArticleTagRelationDto dto) {
        return Result.success(articleTagRelationService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除文章标签关系", description = "根据主键删除文章标签关系记录")
    public Result<Integer> delete(@Parameter(description = "文章标签关系主键") @PathVariable Long id) {
        return Result.success(articleTagRelationService.delete(id));
    }
}