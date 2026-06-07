package com.g2rain.cms.api;

import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.model.Result;
import com.g2rain.cms.dto.TagSelectDto;
import com.g2rain.cms.dto.TagSelectByArticleIdsDto;
import com.g2rain.cms.vo.TagVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "标签", description = "内容标签：列表、分页与按文章批量查询")
public interface TagApi {

    /**
     * 根据条件查询列表
     *
     * @param selectDto 查询条件DTO
     * @return 数据列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询标签列表", description = "按查询条件筛选标签，不分页返回列表")
    Result<List<TagVo>> selectList(TagSelectDto selectDto);

    /**
     * 根据条件分页查询
     *
     * @param selectDto 查询条件DTO（包含分页参数）
     * @return 分页数据
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询标签", description = "按查询条件筛选标签并分页，含总数与当前页数据")
    Result<PageData<TagVo>> selectPage(PageSelectListDto<TagSelectDto> selectDto);

    /**
     * 根据文章ID列表查询每篇文章对应的tag列表
     *
     * @param request 入参（articleIds 列表）
     * @return Map(ArticleId -> TagVo列表)
     */
    @PostMapping("/by_article")
    @Operation(summary = "按文章批量查询标签", description = "根据文章主键列表，返回每篇文章对应的标签列表映射")
    Result<Map<Long, List<TagVo>>> selectTagsByArticleIds(@RequestBody TagSelectByArticleIdsDto request);
}