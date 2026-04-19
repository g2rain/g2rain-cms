package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.PageConverter;
import com.g2rain.cms.dao.PageDao;
import com.g2rain.cms.dao.po.PagePo;
import com.g2rain.cms.dto.PageDto;
import com.g2rain.cms.dto.PageSelectDto;
import com.g2rain.cms.service.PageService;
import com.g2rain.cms.vo.PageVo;
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
 * 页面表服务实现类
 * 表名: page
 *
 * @author G2rain Generator
 */
@Service(value = "pageServiceImpl")
public class PageServiceImpl implements PageService {

    @Resource(name = "pageDao")
    private PageDao pageDao;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<PageVo> selectList(PageSelectDto selectDto) {
        return pageDao.selectList(selectDto)
                .stream()
                .map(PageConverter.INSTANCE::po2vo)
                .toList();
    }

    @Override
    public PageData<PageVo> selectPage(PageSelectListDto<PageSelectDto> selectDto) {
        Page<PagePo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            pageDao.selectList(selectDto.getQuery());
        });
        List<PageVo> result = page.getResult()
                .stream()
                .map(PageConverter.INSTANCE::po2vo)
                .toList();
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Long save(PageDto dto) {
        // 转换DTO为PO
        PagePo entity = PageConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = pageDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 更新：直接更新
            entity.setUpdateTime(Moments.now());
            int success = pageDao.update(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, id);
        }

        return entity.getId();
    }

    @Override
    public int delete(Long id) {
        return pageDao.delete(id);
    }
}