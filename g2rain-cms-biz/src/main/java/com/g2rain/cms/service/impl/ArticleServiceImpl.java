package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.ArticleConverter;
import com.g2rain.cms.dao.ArticleDao;
import com.g2rain.cms.dao.po.ArticlePo;
import com.g2rain.cms.dto.ArticleDto;
import com.g2rain.cms.dto.ArticleSelectDto;
import com.g2rain.cms.dto.TagSelectByArticleIdsDto;
import com.g2rain.cms.service.ArticleService;
import com.g2rain.cms.service.TagService;
import com.g2rain.cms.vo.ArticleDetailVo;
import com.g2rain.cms.vo.ArticleVo;
import com.g2rain.mybatis.pagination.PageContext;
import com.g2rain.mybatis.pagination.model.Page;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 文章表服务实现类
 * 表名: article
 *
 * @author G2rain Generator
 */
@Service(value = "articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {

    @Resource(name = "articleDao")
    private ArticleDao articleDao;

    @Resource(name = "tagServiceImpl")
    private TagService tagService;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<ArticleVo> selectList(ArticleSelectDto selectDto) {
        List<ArticlePo> pos = articleDao.selectList(selectDto);
        List<ArticleVo> vos = pos.stream()
                .map(ArticleConverter.INSTANCE::po2vo)
                .toList();

        if (!vos.isEmpty()) {
            List<Long> articleIds = pos.stream()
                    .map(ArticlePo::getId)
                    .filter(Objects::nonNull)
                    .toList();

            TagSelectByArticleIdsDto tagSelectByArticleIdsDto = new TagSelectByArticleIdsDto();
            tagSelectByArticleIdsDto.setArticleIds(articleIds);
            var tagsMap = tagService.selectTagsByArticleIds(tagSelectByArticleIdsDto);

            for (ArticleVo vo : vos) {
                vo.setTags(tagsMap.getOrDefault(vo.getId(), Collections.emptyList()));
            }
        }

        return vos;
    }

    @Override
    public PageData<ArticleVo> selectPage(PageSelectListDto<ArticleSelectDto> selectDto) {
        Page<ArticlePo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            articleDao.selectList(selectDto.getQuery());
        });

        List<ArticlePo> pos = page.getResult();
        List<ArticleVo> result = pos.stream()
                .map(ArticleConverter.INSTANCE::po2vo)
                .toList();

        if (!result.isEmpty()) {
            List<Long> articleIds = pos.stream()
                    .map(ArticlePo::getId)
                    .filter(Objects::nonNull)
                    .toList();

            TagSelectByArticleIdsDto tagSelectByArticleIdsDto = new TagSelectByArticleIdsDto();
            tagSelectByArticleIdsDto.setArticleIds(articleIds);
            var tagsMap = tagService.selectTagsByArticleIds(tagSelectByArticleIdsDto);

            for (ArticleVo vo : result) {
                vo.setTags(tagsMap.getOrDefault(vo.getId(), Collections.emptyList()));
            }
        }
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Override
    public ArticleDetailVo detail(Long id) {
        ArticlePo po = articleDao.selectById(id);
        if (Objects.isNull(po)) {
            return null;
        }

        ArticleDetailVo detailVo = ArticleConverter.INSTANCE.po2detailVo(po);
        TagSelectByArticleIdsDto tagSelectByArticleIdsDto = new TagSelectByArticleIdsDto();
        tagSelectByArticleIdsDto.setArticleIds(List.of(id));
        var tagsMap = tagService.selectTagsByArticleIds(tagSelectByArticleIdsDto);
        detailVo.setTags(tagsMap.getOrDefault(id, Collections.emptyList()));
        return detailVo;
    }

    @Override
    public Long save(ArticleDto dto) {
        // 转换DTO为PO
        ArticlePo entity = ArticleConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = articleDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 更新：直接更新
            entity.setUpdateTime(Moments.now());
            int success = articleDao.update(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, id);
        }

        return entity.getId();
    }

    @Override
    public int delete(Long id) {
        return articleDao.delete(id);
    }
}