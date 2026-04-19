package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.WebSiteConverter;
import com.g2rain.cms.dao.WebSiteDao;
import com.g2rain.cms.dao.po.WebSitePo;
import com.g2rain.cms.dto.WebSiteDto;
import com.g2rain.cms.dto.WebSiteSelectDto;
import com.g2rain.cms.service.WebSiteService;
import com.g2rain.cms.vo.WebSiteVo;
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
 * 站点表服务实现类
 * 表名: web_site
 *
 * @author G2rain Generator
 */
@Service(value = "webSiteServiceImpl")
public class WebSiteServiceImpl implements WebSiteService {

    @Resource(name = "webSiteDao")
    private WebSiteDao webSiteDao;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<WebSiteVo> selectList(WebSiteSelectDto selectDto) {
        return webSiteDao.selectList(selectDto)
                .stream()
                .map(WebSiteConverter.INSTANCE::po2vo)
                .toList();
    }

    @Override
    public PageData<WebSiteVo> selectPage(PageSelectListDto<WebSiteSelectDto> selectDto) {
        Page<WebSitePo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            webSiteDao.selectList(selectDto.getQuery());
        });
        List<WebSiteVo> result = page.getResult()
                .stream()
                .map(WebSiteConverter.INSTANCE::po2vo)
                .toList();
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Long save(WebSiteDto dto) {
        // 转换DTO为PO
        WebSitePo entity = WebSiteConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = webSiteDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 更新：直接更新
            entity.setUpdateTime(Moments.now());
            int success = webSiteDao.update(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, id);
        }

        return entity.getId();
    }

    @Override
    public int delete(Long id) {
        return webSiteDao.delete(id);
    }
}