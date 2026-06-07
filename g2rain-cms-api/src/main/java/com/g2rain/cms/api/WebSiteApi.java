package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.WebSiteSelectDto;
import com.g2rain.cms.vo.WebSiteVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 站点表API接口
 * 表名: web_site
 *
 * @author G2rain Generator
 */
@Tag(name = "站点", description = "站点（官网站点）配置：列表与分页查询")
public interface WebSiteApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询站点列表", description = "按查询条件筛选站点，不分页返回列表")
    Result<List<WebSiteVo>> selectList(WebSiteSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询站点", description = "按查询条件筛选站点并分页，含总数与当前页数据")
    Result<PageData<WebSiteVo>> selectPage(PageSelectListDto<WebSiteSelectDto> selectDto);
}