package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.SpaceApi;
import com.g2rain.cms.dto.SpaceDto;
import com.g2rain.cms.dto.SpaceSelectDto;
import com.g2rain.cms.dto.SpaceUpdateStatusDto;
import com.g2rain.cms.service.SpaceService;
import com.g2rain.cms.vo.SpaceVo;
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
 * 内容空间表控制器
 * 表名: space
 *
 * @author G2rain Generator
 */
@Tag(name = "内容空间", description = "内容空间（站点下的内容域）：查询、保存与删除")
@RestController
@RequestMapping("/space")
public class SpaceController implements SpaceApi {

    @Resource(name = "spaceServiceImpl")
    private SpaceService spaceService;

    @Override
    @Operation(summary = "查询内容空间列表", description = "按查询条件筛选内容空间，不分页返回列表")
    public Result<List<SpaceVo>> selectList(SpaceSelectDto selectDto) {
        return Result.success(spaceService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询内容空间", description = "按查询条件筛选内容空间并分页，含总数与当前页数据")
    public Result<PageData<SpaceVo>> selectPage(PageSelectListDto<SpaceSelectDto> selectDto) {
        return Result.successPage(spaceService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新内容空间", description = "根据请求体主键是否存在，新增或更新内容空间信息")
    public Result<Long> save(@RequestBody SpaceDto dto) {
        return Result.success(spaceService.save(dto));
    }
    
    @PostMapping("/update_status")
    @Operation(summary = "内容空间状态变更")
    public Result<Integer> updateStatus(@RequestBody SpaceUpdateStatusDto dto) {
        return Result.success(spaceService.updateStatus(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除内容空间", description = "根据主键删除内容空间记录")
    public Result<Integer> delete(@Parameter(description = "内容空间主键") @PathVariable Long id) {
        return Result.success(spaceService.delete(id));
    }
}