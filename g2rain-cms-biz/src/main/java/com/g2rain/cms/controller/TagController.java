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
@Tag(name = "标签", description = "内容标签：列表、分页、按文章批量查询、保存与删除")
@RestController
@RequestMapping("/tag")
public class TagController implements TagApi {

    @Resource(name = "tagServiceImpl")
    private TagService tagService;

    @Override
    @Operation(summary = "查询标签列表", description = "按查询条件筛选标签，不分页返回列表")
    public Result<List<TagVo>> selectList(TagSelectDto selectDto) {
        return Result.success(tagService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询标签", description = "按查询条件筛选标签并分页，含总数与当前页数据")
    public Result<PageData<TagVo>> selectPage(PageSelectListDto<TagSelectDto> selectDto) {
        return Result.successPage(tagService.selectPage(selectDto));
    }

    @Override
    @Operation(summary = "按文章批量查询标签", description = "根据文章主键列表，返回每篇文章对应的标签列表映射")
    public Result<Map<Long, List<TagVo>>> selectTagsByArticleIds(@RequestBody TagSelectByArticleIdsDto request) {
        return Result.success(tagService.selectTagsByArticleIds(request));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新标签", description = "根据请求体主键是否存在，新增或更新标签信息")
    public Result<Long> save(@RequestBody TagDto dto) {
        return Result.success(tagService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除标签", description = "根据主键删除标签记录")
    public Result<Integer> delete(@Parameter(description = "标签主键") @PathVariable Long id) {
        return Result.success(tagService.delete(id));
    }
}