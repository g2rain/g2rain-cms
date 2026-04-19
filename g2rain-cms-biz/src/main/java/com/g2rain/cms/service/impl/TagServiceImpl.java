package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.TagConverter;
import com.g2rain.cms.dao.TagDao;
import com.g2rain.cms.dao.po.TagPo;
import com.g2rain.cms.dao.po.TagWithArticleIdPo;
import com.g2rain.cms.dto.TagDto;
import com.g2rain.cms.dto.TagSelectDto;
import com.g2rain.cms.dto.TagSelectByArticleIdsDto;
import com.g2rain.cms.service.TagService;
import com.g2rain.cms.vo.TagVo;
import com.g2rain.mybatis.pagination.PageContext;
import com.g2rain.mybatis.pagination.model.Page;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 标签表服务实现类
 * 表名: tag
 *
 * @author G2rain Generator
 */
@Service(value = "tagServiceImpl")
public class TagServiceImpl implements TagService {

    @Resource(name = "tagDao")
    private TagDao tagDao;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<TagVo> selectList(TagSelectDto selectDto) {
        return tagDao.selectList(selectDto)
                .stream()
                .map(TagConverter.INSTANCE::po2vo)
                .toList();
    }

    @Override
    public PageData<TagVo> selectPage(PageSelectListDto<TagSelectDto> selectDto) {
        Page<TagPo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            tagDao.selectList(selectDto.getQuery());
        });
        List<TagVo> result = page.getResult()
                .stream()
                .map(TagConverter.INSTANCE::po2vo)
                .toList();
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Map<Long, List<TagVo>> selectTagsByArticleIds(TagSelectByArticleIdsDto request) {
        List<Long> articleIds = request == null ? null : request.getArticleIds();
        if (articleIds == null || articleIds.isEmpty()) {
            return Map.of();
        }

        // 先把每个 articleId 初始化出来，保证“每个文章对应的 tag 列表”都有返回数据
        // 同时准备 result，避免最后再遍历 grouped 组装一次
        Map<Long, LinkedHashMap<Long, TagVo>> grouped = new LinkedHashMap<>();
        Map<Long, List<TagVo>> result = new LinkedHashMap<>();
        for (Long articleId : articleIds) {
            if (articleId != null) {
                grouped.put(articleId, new LinkedHashMap<>());
                result.put(articleId, new ArrayList<>());
            }
        }

        // 联表一次性拿到：article_id + tag(*)，避免两次查询带来的额外 IO
        List<TagWithArticleIdPo> rows = tagDao.selectTagsByArticleIds(articleIds);
        if (rows != null) {
            for (TagWithArticleIdPo row : rows) {
                Long articleId = row.getArticleId();
                if (articleId == null) {
                    continue;
                }

                // 按 tagId（= tagPo.id）去重，同一个文章保留插入顺序
                LinkedHashMap<Long, TagVo> tagMap = grouped.computeIfAbsent(articleId, k -> new LinkedHashMap<>());
                List<TagVo> list = result.computeIfAbsent(articleId, k -> new ArrayList<>());

                TagVo vo = TagConverter.INSTANCE.po2vo(row);
                Long tagId = row.getId();
                if (tagId == null) {
                    continue;
                }

                TagVo existed = tagMap.putIfAbsent(tagId, vo);
                if (existed == null) {
                    list.add(vo);
                }
            }
        }
        return result;
    }

    @Override
    public Long save(TagDto dto) {
        // 转换DTO为PO
        TagPo entity = TagConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = tagDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 更新：直接更新
            entity.setUpdateTime(Moments.now());
            int success = tagDao.update(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, id);
        }

        return entity.getId();
    }

    @Override
    public int delete(Long id) {
        return tagDao.delete(id);
    }
}