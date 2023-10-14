package com.hb.mall.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.lang.tree.parser.NodeParser;
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
        AreaModel areaModel = baseMapper.selectOne(new LambdaQueryWrapper<AreaModel>().eq(AreaModel::getAreaId, areaId));
        return AreaConvert.MAPPER.targetDto(areaModel);
    }

    @Override
    public List<AreaDTO> queryListByParentAreaId(Long parentAreaId) {
        List<AreaModel> areaModelList = baseMapper.selectList(new LambdaQueryWrapper<AreaModel>()
                .eq(AreaModel::getParentId, parentAreaId));
        return AreaConvert.MAPPER.targetDtoList(areaModelList);
    }

    @Override
    // TODO
    public List<AreaDTO> queryTreeByParentAreaId(Long parentAreaId) {
        List<AreaModel> areaModelList = baseMapper.selectList(new LambdaQueryWrapper<AreaModel>()
                .eq(AreaModel::getParentId, parentAreaId));
        TreeNodeConfig config = new TreeNodeConfig();
        config.setIdKey("area_id");//默认为id可以不设置
        //config.setParentIdKey("parentId");//默认为parentId可以不设置
        //config.setDeep(4);//最大递归深度
//        config.setWeightKey("priority");//排序字段

        List<Tree<Long>> trees = TreeUtil.build(areaModelList, 0L, config, new NodeParser<AreaModel, Long>() {
            @Override
            public void parse(AreaModel areaModel, Tree<Long> tree) {
                // 也可以使用 tree.setId(object.getId());等一些默认值
                tree.putExtra("areaId", areaModel.getAreaId());
                tree.putExtra("parentId", areaModel.getParentId());
                tree.putExtra("level", areaModel.getLevel());
//                tree.putExtra("levelName", object.getLevelName());
//                tree.putExtra("isEfficient", object.getIsEfficient());
//                tree.putExtra("isShow", object.getIsShow());

            }
        });
        System.out.println(trees);
        return null;
    }
}
