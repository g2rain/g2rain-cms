package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.ChannelApi;
import com.g2rain.cms.dto.ChannelDto;
import com.g2rain.cms.dto.ChannelSelectDto;
import com.g2rain.cms.service.ChannelService;
import com.g2rain.cms.vo.ChannelVo;
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
 * 栏目表控制器
 * 表名: channel
 *
 * @author G2rain Generator
 */
@Tag(name = "栏目", description = "导航栏目：查询、保存与删除")
@RestController
@RequestMapping("/channel")
public class ChannelController implements ChannelApi {

    @Resource(name = "channelServiceImpl")
    private ChannelService channelService;

    @Override
    @Operation(summary = "查询栏目列表", description = "按查询条件筛选栏目，不分页返回列表")
    public Result<List<ChannelVo>> selectList(ChannelSelectDto selectDto) {
        return Result.success(channelService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询栏目", description = "按查询条件筛选栏目并分页，含总数与当前页数据")
    public Result<PageData<ChannelVo>> selectPage(PageSelectListDto<ChannelSelectDto> selectDto) {
        return Result.successPage(channelService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新栏目", description = "根据请求体主键是否存在，新增或更新栏目信息")
    public Result<Long> save(@RequestBody ChannelDto dto) {
        return Result.success(channelService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除栏目", description = "根据主键删除栏目记录")
    public Result<Integer> delete(@Parameter(description = "栏目主键") @PathVariable Long id) {
        return Result.success(channelService.delete(id));
    }
}