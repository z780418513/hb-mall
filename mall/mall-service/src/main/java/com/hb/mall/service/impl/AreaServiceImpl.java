package com.hb.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.dao.entity.AreaModel;
import com.hb.mall.dao.mapper.AreaMapper;
import com.hb.mall.service.AreaService;
import com.hb.mall.service.convert.AreaConvert;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhaochengshui
 * @description Area服务类
 * @date: 2023/10/14 16:06
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaModel> implements AreaService {

    @Override
    public AreaDTO queryByAreaId(Long areaId) {
        AreaModel areaModel = baseMapper.selectOne(new LambdaQueryWrapper<AreaModel>().eq(areaId != null, AreaModel::getAreaId, areaId));
        return AreaConvert.MAPPER.targetDto(areaModel);
    }

    @Override
    public List<AreaDTO> queryListByParentAreaId(Long parentAreaId) {
        return null;
    }

    @Override
    public List<AreaDTO> queryTreeByParentAreaId(Long parentAreaId) {
        return null;
    }
}
