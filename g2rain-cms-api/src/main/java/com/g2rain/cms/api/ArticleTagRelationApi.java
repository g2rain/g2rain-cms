package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.ArticleTagRelationSelectDto;
import com.g2rain.cms.vo.ArticleTagRelationVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 文章标签关系表API接口
 * 表名: article_tag_relation
 *
 * @author G2rain Generator
 */
@Tag(name = "文章标签关系", description = "文章与标签关联：列表与分页查询")
public interface ArticleTagRelationApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询文章标签关系列表", description = "按查询条件筛选文章标签关系，不分页返回列表")
    Result<List<ArticleTagRelationVo>> selectList(ArticleTagRelationSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询文章标签关系", description = "按查询条件筛选文章标签关系并分页，含总数与当前页数据")
    Result<PageData<ArticleTagRelationVo>> selectPage(PageSelectListDto<ArticleTagRelationSelectDto> selectDto);
}