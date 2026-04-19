package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.PageApi;
import com.g2rain.cms.dto.PageDto;
import com.g2rain.cms.dto.PageSelectDto;
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
@Tag(name = "页面")
@RestController
@RequestMapping("/page")
public class PageController implements PageApi {

    @Resource(name = "pageServiceImpl")
    private PageService pageService;

    @Override
    @Operation(summary = "页面列表查询")
    public Result<List<PageVo>> selectList(PageSelectDto selectDto) {
        return Result.success(pageService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "页面分页查询")
    public Result<PageData<PageVo>> selectPage(PageSelectListDto<PageSelectDto> selectDto) {
        return Result.successPage(pageService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "页面保存")
    public Result<Long> save(@RequestBody PageDto dto) {
        return Result.success(pageService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "页面删除")
    public Result<Integer> delete(@Parameter(description = "主键") @PathVariable Long id) {
        return Result.success(pageService.delete(id));
    }
}