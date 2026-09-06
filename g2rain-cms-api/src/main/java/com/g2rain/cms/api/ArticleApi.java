package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.ArticleSelectDto;
import com.g2rain.cms.vo.ArticleVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 文章表API接口
 * 表名: article
 *
 * @author G2rain Generator
 */
@Tag(name = "文章表", description = "文章表相关接口")
public interface ArticleApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询文章表列表", description = "根据查询条件返回文章表列表")
    Result<List<ArticleVo>> selectList(ArticleSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询文章表列表", description = "分页查询文章表列表")
    Result<PageData<ArticleVo>> selectPage(PageSelectListDto<ArticleSelectDto> selectDto);
}