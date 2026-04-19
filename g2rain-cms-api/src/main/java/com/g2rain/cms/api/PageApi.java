package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.PageSelectDto;
import com.g2rain.cms.vo.PageVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 页面表API接口
 * 表名: page
 *
 * @author G2rain Generator
 */
public interface PageApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @Operation(summary = "条件列表查询")
    @GetMapping("/list")
    Result<List<PageVo>> selectList(PageSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @Operation(summary = "条件分页查询")
    @GetMapping("/page")
    Result<PageData<PageVo>> selectPage(PageSelectListDto<PageSelectDto> selectDto);
}