package com.hb.mall.admin.controller;

import cn.hutool.core.lang.tree.Tree;
import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.common.core.Result;
import com.hb.mall.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhaochengshui
 * @description 地区服务控制层
 * @date: 2023/10/14 15:48
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    /**
     * 查询地区信息
     *
     * @param areaId 地区ID
     * @return 地区信息
     */
    @GetMapping("/getById")
    public Result<AreaDTO> getByAreaId(@RequestParam Long areaId) {
        return Result.success(areaService.queryByAreaId(areaId));
    }

    /**
     * 查询地区信息集合
     *
     * @param areaId 地区ID
     * @return 地区信息
     */
    @GetMapping("/getList")
    public Result<List<AreaDTO>> getList(@RequestParam(required = false) Long areaId) {
        return Result.success(areaService.queryListByParentAreaId(areaId));
    }

    /**
     * 查询地区信息集合
     *
     * @param areaId 地区ID
     * @return 地区信息
     */
    @GetMapping("/getTreeList")
    public Result<List<Tree<Long>>> getTreeList(@RequestParam Long areaId) {
        return Result.success(areaService.queryTreeListByParentAreaId(areaId));
    }
}
