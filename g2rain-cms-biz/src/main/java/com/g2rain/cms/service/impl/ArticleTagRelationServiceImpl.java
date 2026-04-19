package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.ArticleTagRelationConverter;
import com.g2rain.cms.dao.ArticleTagRelationDao;
import com.g2rain.cms.dto.ArticleTagBatchAddDto;
import com.g2rain.cms.dao.po.ArticleTagRelationPo;
import com.g2rain.cms.dto.ArticleTagRelationDto;
import com.g2rain.cms.dto.ArticleTagRelationSelectDto;
import com.g2rain.cms.service.ArticleTagRelationService;
import com.g2rain.cms.vo.ArticleTagRelationVo;
import com.g2rain.mybatis.pagination.PageContext;
import com.g2rain.mybatis.pagination.model.Page;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;

/**
 * 文章标签关系表服务实现类
 * 表名: article_tag_relation
 *
 * @author G2rain Generator
 */
@Service(value = "articleTagRelationServiceImpl")
public class ArticleTagRelationServiceImpl implements ArticleTagRelationService {

    @Resource(name = "articleTagRelationDao")
    private ArticleTagRelationDao articleTagRelationDao;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<ArticleTagRelationVo> selectList(ArticleTagRelationSelectDto selectDto) {
        return articleTagRelationDao.selectList(selectDto)
                .stream()
                .map(ArticleTagRelationConverter.INSTANCE::po2vo)
                .toList();
    }

    @Override
    public PageData<ArticleTagRelationVo> selectPage(PageSelectListDto<ArticleTagRelationSelectDto> selectDto) {
        Page<ArticleTagRelationPo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            articleTagRelationDao.selectList(selectDto.getQuery());
        });
        List<ArticleTagRelationVo> result = page.getResult()
                .stream()
                .map(ArticleTagRelationConverter.INSTANCE::po2vo)
                .toList();
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int batchAddTags(ArticleTagBatchAddDto dto) {
        if (dto == null || dto.getArticleId() == null || dto.getTagIds() == null || dto.getTagIds().isEmpty()) {
            return 0;
        }

        Long articleId = dto.getArticleId();
        Set<Long> tagIds = dto.getTagIds().stream()
                .filter(Objects::nonNull)
                .collect(java.util.stream.Collectors.toCollection(LinkedHashSet::new));
        if (tagIds.isEmpty()) {
            return 0;
        }

        // 查询当前文章已存在的标签关系，避免重复写入
        ArticleTagRelationSelectDto selectDto = new ArticleTagRelationSelectDto();
        selectDto.setArticleId(articleId);
        List<ArticleTagRelationPo> exists = articleTagRelationDao.selectList(selectDto);
        Set<Long> existsTagIds = exists.stream()
                .map(ArticleTagRelationPo::getTagId)
                .filter(Objects::nonNull)
                .collect(java.util.stream.Collectors.toSet());

        LocalDateTime now = Moments.now();
        List<ArticleTagRelationPo> addList = new ArrayList<>();
        for (Long tagId : tagIds) {
            if (existsTagIds.contains(tagId)) {
                continue;
            }
            ArticleTagRelationPo po = new ArticleTagRelationPo();
            po.setId(idGenerator.generateId());
            po.setArticleId(articleId);
            po.setTagId(tagId);
            po.setCreateTime(now);
            po.setUpdateTime(now);
            addList.add(po);
        }

        if (addList.isEmpty()) {
            return 0;
        }
        return articleTagRelationDao.insertMultiple(addList);
    }

    @Override
    public Long save(ArticleTagRelationDto dto) {
        // 转换DTO为PO
        ArticleTagRelationPo entity = ArticleTagRelationConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = articleTagRelationDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 已存在：直接返回，不做任何修改
            return id;
        }

        return entity.getId();
    }

    @Override
    public int delete(Long id) {
        return articleTagRelationDao.delete(id);
    }
}