package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.TagApi;
import com.g2rain.cms.dto.TagDto;
import com.g2rain.cms.dto.TagSelectDto;
import com.g2rain.cms.dto.TagSelectByArticleIdsDto;
import com.g2rain.cms.service.TagService;
import com.g2rain.cms.vo.TagVo;
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

import java.util.Map;
import java.util.List;

/**
 * 标签表控制器
 * 表名: tag
 *
 * @author G2rain Generator
 */
@Tag(name = "标签")
@RestController
@RequestMapping("/tag")
public class TagController implements TagApi {

    @Resource(name = "tagServiceImpl")
    private TagService tagService;

    @Override
    @Operation(summary = "标签列表查询")
    public Result<List<TagVo>> selectList(TagSelectDto selectDto) {
        return Result.success(tagService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "标签分页查询")
    public Result<PageData<TagVo>> selectPage(PageSelectListDto<TagSelectDto> selectDto) {
        return Result.successPage(tagService.selectPage(selectDto));
    }

    @Override
    @Operation(summary = "根据文章ID列表批量查询标签列表")
    public Result<Map<Long, List<TagVo>>> selectTagsByArticleIds(@RequestBody TagSelectByArticleIdsDto request) {
        return Result.success(tagService.selectTagsByArticleIds(request));
    }

    @PostMapping("/save")
    @Operation(summary = "标签保存")
    public Result<Long> save(@RequestBody TagDto dto) {
        return Result.success(tagService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "标签删除")
    public Result<Integer> delete(@Parameter(description = "主键") @PathVariable Long id) {
        return Result.success(tagService.delete(id));
    }
}