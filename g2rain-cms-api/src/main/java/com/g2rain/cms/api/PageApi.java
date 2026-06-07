package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.PageSelectDto;
import com.g2rain.cms.vo.PageVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 页面表API接口
 * 表名: page
 *
 * @author G2rain Generator
 */
@Tag(name = "页面", description = "页面内容：列表与分页查询")
public interface PageApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询页面列表", description = "按查询条件筛选页面，不分页返回列表")
    Result<List<PageVo>> selectList(PageSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询页面", description = "按查询条件筛选页面并分页，含总数与当前页数据")
    Result<PageData<PageVo>> selectPage(PageSelectListDto<PageSelectDto> selectDto);
}