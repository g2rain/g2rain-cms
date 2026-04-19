package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.WebSiteSelectDto;
import com.g2rain.cms.vo.WebSiteVo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 站点表API接口
 * 表名: web_site
 *
 * @author G2rain Generator
 */
public interface WebSiteApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    Result<List<WebSiteVo>> selectList(WebSiteSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    Result<PageData<WebSiteVo>> selectPage(PageSelectListDto<WebSiteSelectDto> selectDto);
}