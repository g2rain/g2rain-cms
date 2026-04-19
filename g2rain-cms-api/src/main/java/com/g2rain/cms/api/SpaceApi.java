package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.SpaceSelectDto;
import com.g2rain.cms.vo.SpaceVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 内容空间表API接口
 * 表名: space
 *
 * @author G2rain Generator
 */
public interface SpaceApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @Operation(summary = "条件列表查询")
    @GetMapping("/list")
    Result<List<SpaceVo>> selectList(SpaceSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @Operation(summary = "条件分页查询")
    @GetMapping("/page")
    Result<PageData<SpaceVo>> selectPage(PageSelectListDto<SpaceSelectDto> selectDto);
}