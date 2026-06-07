package com.g2rain.cms.service.impl;

import com.g2rain.common.exception.SystemErrorCode;
import com.g2rain.common.id.IdGenerator;
import com.g2rain.common.model.PageData;
import com.g2rain.common.model.PageSelectListDto;
import com.g2rain.common.utils.Asserts;
import com.g2rain.common.utils.Moments;
import com.g2rain.cms.converter.SpaceConverter;
import com.g2rain.cms.dao.SpaceDao;
import com.g2rain.cms.dao.po.SpacePo;
import com.g2rain.cms.dto.SpaceDto;
import com.g2rain.cms.dto.SpaceSelectDto;
import com.g2rain.cms.dto.SpaceUpdateStatusDto;
import com.g2rain.cms.service.SpaceService;
import com.g2rain.cms.vo.SpaceVo;
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
 * 内容空间表服务实现类
 * 表名: space
 *
 * @author G2rain Generator
 */
@Service(value = "spaceServiceImpl")
public class SpaceServiceImpl implements SpaceService {

    @Resource(name = "spaceDao")
    private SpaceDao spaceDao;

    private IdGenerator idGenerator;

    @Qualifier("idGenerator")
    @Autowired(required = false)
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<SpaceVo> selectList(SpaceSelectDto selectDto) {
        return spaceDao.selectList(selectDto)
                .stream()
                .map(SpaceConverter.INSTANCE::po2vo)
                .toList();
    }

    @Override
    public PageData<SpaceVo> selectPage(PageSelectListDto<SpaceSelectDto> selectDto) {
        Page<SpacePo> page = PageContext.of(selectDto.getPageNum(), selectDto.getPageSize(), () -> {
            spaceDao.selectList(selectDto.getQuery());
        });
        List<SpaceVo> result = page.getResult()
                .stream()
                .map(SpaceConverter.INSTANCE::po2vo)
                .toList();
        return PageData.of(page.getPageNum(), page.getPageSize(), page.getTotal(), result);
    }

    @Override
    public Long save(SpaceDto dto) {
        // 转换DTO为PO
        SpacePo entity = SpaceConverter.INSTANCE.dto2po(dto);

        // 判断是新增还是更新
        Long id = entity.getId();
        if (Objects.isNull(id) || id == 0) {
            // 新增：使用IdGenerator生成主键
            entity.setId(idGenerator.generateId());
            LocalDateTime now = Moments.now();
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            int success = spaceDao.insert(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.CREATE_DATA_ERROR);
        } else {
            // 更新：直接更新
            entity.setUpdateTime(Moments.now());
            int success = spaceDao.update(entity);
            Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, id);
        }

        return entity.getId();
    }

    @Override
    public int updateStatus(SpaceUpdateStatusDto dto) {
        if (dto == null || dto.getId() == null || dto.getStatus() == null || dto.getStatus().isBlank()) {
            throw new IllegalArgumentException("space updateStatus requires id and status");
        }

        SpacePo entity = new SpacePo();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setUpdateTime(Moments.now());
        int success = spaceDao.update(entity);
        Asserts.greaterThan(success, 0, SystemErrorCode.UPDATE_DATA_ERROR, dto.getId());
        return success;
    }

    @Override
    public int delete(Long id) {
        return spaceDao.delete(id);
    }
}