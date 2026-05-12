package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.PageApi;
import com.g2rain.cms.dto.PageDto;
import com.g2rain.cms.dto.PageSelectDto;
import com.g2rain.cms.dto.PageUpdateStatusDto;
import com.g2rain.cms.service.PageService;
import com.g2rain.cms.vo.PageVo;
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
 * 页面表控制器
 * 表名: page
 *
 * @author G2rain Generator
 */
@Tag(name = "页面", description = "页面内容：查询、保存与删除")
@RestController
@RequestMapping("/page")
public class PageController implements PageApi {

    @Resource(name = "pageServiceImpl")
    private PageService pageService;

    @Override
    @Operation(summary = "查询页面列表", description = "按查询条件筛选页面，不分页返回列表")
    public Result<List<PageVo>> selectList(PageSelectDto selectDto) {
        return Result.success(pageService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询页面", description = "按查询条件筛选页面并分页，含总数与当前页数据")
    public Result<PageData<PageVo>> selectPage(PageSelectListDto<PageSelectDto> selectDto) {
        return Result.successPage(pageService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新页面", description = "根据请求体主键是否存在，新增或更新页面信息")
    public Result<Long> save(@RequestBody PageDto dto) {
        return Result.success(pageService.save(dto));
    }

    @PostMapping("/update_status")
    @Operation(summary = "页面状态变更")
    public Result<Integer> updateStatus(@RequestBody PageUpdateStatusDto dto) {
        return Result.success(pageService.updateStatus(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除页面", description = "根据主键删除页面记录")
    public Result<Integer> delete(@Parameter(description = "页面主键") @PathVariable Long id) {
        return Result.success(pageService.delete(id));
    }
}