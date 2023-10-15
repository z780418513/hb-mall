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
import com.hb.mall.service.convert.AreaConvertMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author: zhaochengshui
 * @description Area服务类
 * @date: 2023/10/14 16:06
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaModel> implements AreaService {
    @Resource
    private AreaConvertMapper areaConvertMapper;

    @Override
    public AreaDTO queryByAreaId(Long areaId) {
        AreaModel areaModel = baseMapper.selectOne(new LambdaQueryWrapper<AreaModel>().eq(AreaModel::getId, areaId));
        return areaConvertMapper.toTarget(areaModel);
    }

    @Override
    public List<AreaDTO> queryListByParentAreaId(@Nullable Long parentAreaId) {
        if (Objects.isNull(parentAreaId)) {
            parentAreaId = 0L;
        }
        List<AreaModel> areaModelList = baseMapper.selectList(new LambdaQueryWrapper<AreaModel>()
                .eq(AreaModel::getParentId, parentAreaId));
        return areaConvertMapper.toTargetList(areaModelList);
    }

    @Override
    public List<Tree<Long>> queryTreeListByParentAreaId(Long parentAreaId) {
        List<AreaModel> allArealList = baseMapper.selectList(new QueryWrapper<>());
        return TreeHelper.toTreeList(allArealList, parentAreaId);
    }

    @Override
    public Boolean add(AreaDTO areaDTO) {
        AreaModel model = areaConvertMapper.toSource(areaDTO);
        baseMapper.insert(model);
        return baseMapper.insert(model) > 0;
    }
}
