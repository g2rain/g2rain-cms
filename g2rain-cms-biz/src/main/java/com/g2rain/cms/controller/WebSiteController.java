package com.g2rain.cms.controller;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.api.WebSiteApi;
import com.g2rain.cms.dto.WebSiteDto;
import com.g2rain.cms.dto.WebSiteSelectDto;
import com.g2rain.cms.service.WebSiteService;
import com.g2rain.cms.vo.WebSiteVo;
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
@RestController
@RequestMapping("/web_site")
public class WebSiteController implements WebSiteApi {

    @Resource(name = "webSiteServiceImpl")
    private WebSiteService webSiteService;

    @Override
    public Result<List<WebSiteVo>> selectList(WebSiteSelectDto selectDto) {
        return Result.success(webSiteService.selectList(selectDto));
    }

    @Override
    public Result<PageData<WebSiteVo>> selectPage(PageSelectListDto<WebSiteSelectDto> selectDto) {
        return Result.successPage(webSiteService.selectPage(selectDto));
    }

    @PostMapping("/save")
    public Result<Long> save(@RequestBody WebSiteDto dto) {
        return Result.success(webSiteService.save(dto));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.success(webSiteService.delete(id));
    }
}