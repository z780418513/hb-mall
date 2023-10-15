package com.hb.mall.service.impl;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.common.utils.TreeHelper;
import com.hb.mall.dao.entity.AreaModel;
import com.hb.mall.dao.mapper.AreaMapper;
import com.hb.mall.service.AreaService;
import com.hb.mall.service.convert.AreaConvert;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author: zhaochengshui
 * @description Area服务类
 * @date: 2023/10/14 16:06
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaModel> implements AreaService {

    @Override
    public AreaDTO queryByAreaId(Long areaId) {
        AreaModel areaModel = baseMapper.selectOne(new LambdaQueryWrapper<AreaModel>().eq(AreaModel::getId, areaId));
        return AreaConvert.MAPPER.targetDto(areaModel);
    }

    @Override
    public List<AreaDTO> queryListByParentAreaId(@Nullable Long parentAreaId) {
        if (Objects.isNull(parentAreaId)) {
            parentAreaId = 0L;
        }
        List<AreaModel> areaModelList = baseMapper.selectList(new LambdaQueryWrapper<AreaModel>()
                .eq(AreaModel::getParentId, parentAreaId));
        return AreaConvert.MAPPER.targetDtoList(areaModelList);
    }

    @Override
    public List<Tree<Long>> queryTreeListByParentAreaId(Long parentAreaId) {
        List<AreaModel> allArealList = baseMapper.selectList(new QueryWrapper<>());
        return TreeHelper.toTreeList(allArealList, parentAreaId);
    }
}
