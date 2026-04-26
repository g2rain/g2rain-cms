package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.ArticleCategoryConverter;
import com.g2rain.cms.dao.ArticleCategoryDao;
import com.g2rain.cms.dao.po.ArticleCategoryPo;
import com.g2rain.cms.dto.ArticleCategoryDto;
import com.g2rain.cms.dto.ArticleCategorySelectDto;
import com.g2rain.cms.dto.ArticleCategoryUpdateStatusDto;
import com.g2rain.cms.service.ArticleCategoryService;
import com.g2rain.cms.vo.ArticleCategoryVo;
import com.g2rain.mybatis.pagination.PageContext;
import com.g2rain.mybatis.pagination.model.Page;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 文章分类表服务实现类
 * 表名: article_category
 *
 * @author G2rain Generator
 */
@Service(value = "articleCategoryServiceImpl")
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Resource(name = "articleCategoryDao")
    private ArticleCategoryDao articleCategoryDao;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<ArticleCategoryVo> selectList(ArticleCategorySelectDto selectDto) {
        return articleCategoryDao.selectList(selectDto)
                .stream()
                .map(ArticleCategoryConverter.INSTANCE::po2vo)
                .toList();
    }

    @Override
    public PageData<ArticleCategoryVo> selectPage(PageSelectListDto<ArticleCategorySelectDto> selectDto) {
        Page<ArticleCategoryPo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            articleCategoryDao.selectList(selectDto.getQuery());
        });
        List<ArticleCategoryVo> result = page.getResult()
                .stream()
                .map(ArticleCategoryConverter.INSTANCE::po2vo)
                .toList();
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Long save(ArticleCategoryDto dto) {
        // 转换DTO为PO
        ArticleCategoryPo entity = ArticleCategoryConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = articleCategoryDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 更新：直接更新
            entity.setUpdateTime(Moments.now());
            int success = articleCategoryDao.update(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, id);
        }

        return entity.getId();
    }

    @Override
    public int updateStatus(ArticleCategoryUpdateStatusDto dto) {
        if (dto == null || dto.getId() == null || dto.getStatus() == null || dto.getStatus().isBlank()) {
            throw new IllegalArgumentException("articleCategory updateStatus requires id and status");
        }

        ArticleCategoryPo entity = new ArticleCategoryPo();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setUpdateTime(Moments.now());
        int success = articleCategoryDao.update(entity);
        Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, dto.getId());
        return success;
    }

    @Override
    public int delete(Long id) {
        return articleCategoryDao.delete(id);
    }
}