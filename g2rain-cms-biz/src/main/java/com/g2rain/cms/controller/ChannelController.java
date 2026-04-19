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
@Tag(name = "栏目")
@RestController
@RequestMapping("/channel")
public class ChannelController implements ChannelApi {

    @Resource(name = "channelServiceImpl")
    private ChannelService channelService;

    @Override
    @Operation(summary = "栏目列表查询")
    public Result<List<ChannelVo>> selectList(ChannelSelectDto selectDto) {
        return Result.success(channelService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "栏目分页查询")
    public Result<PageData<ChannelVo>> selectPage(PageSelectListDto<ChannelSelectDto> selectDto) {
        return Result.successPage(channelService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "栏目保存")
    public Result<Long> save(@RequestBody ChannelDto dto) {
        return Result.success(channelService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "栏目删除")
    public Result<Integer> delete(@Parameter(description = "主键") @PathVariable Long id) {
        return Result.success(channelService.delete(id));
    }
}