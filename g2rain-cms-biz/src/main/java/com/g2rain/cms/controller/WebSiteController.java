package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.WebSiteApi;
import com.g2rain.cms.dto.WebSiteDto;
import com.g2rain.cms.dto.WebSiteSelectDto;
import com.g2rain.cms.service.WebSiteService;
import com.g2rain.cms.vo.WebSiteVo;
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
 * 站点表控制器
 * 表名: web_site
 *
 * @author G2rain Generator
 */
@Tag(name = "站点", description = "站点（官网站点）配置与维护：查询、保存与删除")
@RestController
@RequestMapping("/web_site")
public class WebSiteController implements WebSiteApi {

    @Resource(name = "webSiteServiceImpl")
    private WebSiteService webSiteService;

    @Override
    @Operation(summary = "查询站点列表", description = "按查询条件筛选站点，不分页返回列表")
    public Result<List<WebSiteVo>> selectList(WebSiteSelectDto selectDto) {
        return Result.success(webSiteService.selectList(selectDto));
    }

    @Override
    @Operation(summary = "分页查询站点", description = "按查询条件筛选站点并分页，含总数与当前页数据")
    public Result<PageData<WebSiteVo>> selectPage(PageSelectListDto<WebSiteSelectDto> selectDto) {
        return Result.successPage(webSiteService.selectPage(selectDto));
    }

    @PostMapping("/save")
    @Operation(summary = "新增或更新站点", description = "根据请求体主键是否存在，新增或更新站点信息")
    public Result<Long> save(@RequestBody WebSiteDto dto) {
        return Result.success(webSiteService.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除站点", description = "根据主键删除站点记录")
    public Result<Integer> delete(@Parameter(description = "站点主键") @PathVariable Long id) {
        return Result.success(webSiteService.delete(id));
    }
}