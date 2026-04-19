package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.TagSelectDto;
import com.g2rain.cms.dto.TagSelectByArticleIdsDto;
import com.g2rain.cms.vo.TagVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


/**
 * 标签表API接口
 * 表名: tag
 *
 * @author G2rain Generator
 */
public interface TagApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @Operation(summary = "条件列表查询")
    @GetMapping("/list")
    Result<List<TagVo>> selectList(TagSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @Operation(summary = "条件分页查询")
    @GetMapping("/page")
    Result<PageData<TagVo>> selectPage(PageSelectListDto<TagSelectDto> selectDto);

    /**
     * 根据文章ID列表查询每篇文章对应的tag列表
     *
     * @param request 入参（articleIds 列表）
     * @return Map(ArticleId -> TagVo列表)
     */
    @Operation(summary = "根据文章ID列表批量查询标签列表")
    @PostMapping("/by_article")
    Result<Map<Long, List<TagVo>>> selectTagsByArticleIds(@RequestBody TagSelectByArticleIdsDto request);
}