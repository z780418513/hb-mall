package com.hb.mall.service;

import cn.hutool.core.lang.tree.Tree;
import com.hb.mall.api.dto.AreaDTO;

import java.util.List;

public interface AreaService  {
    /**
     * 查询地区信息
     *
     * @param areaId areaId
     * @return 地区信息
     */
    AreaDTO queryByAreaId(Long areaId);

    /**
     * 根据父areaId查询其所有子级地区内容
     *
     * @param parentAreaId 父AreaId
     * @return 所有子级地区内容
     */
    List<AreaDTO> queryListByParentAreaId(Long parentAreaId);


    /**
     * 根据父areaId查询其所有子级地区内容(树形)
     *
     * @param parentAreaId 父AreaId
     * @return 所有子级地区内容(树形)
     */
    List<Tree<Long>> queryTreeListByParentAreaId(Long parentAreaId) ;
}
