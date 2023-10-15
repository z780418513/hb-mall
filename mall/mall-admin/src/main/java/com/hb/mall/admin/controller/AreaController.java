package com.hb.mall.admin.controller;

import cn.hutool.core.lang.tree.Tree;
import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.common.core.Result;
import com.hb.mall.common.core.ValidGroup;
import com.hb.mall.service.AreaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 新增地区信息
     *
     * @param areaDTO areaDTO
     * @return boolean
     */
    @GetMapping("/add")
    public Result<Boolean> add(@RequestBody @Validated(value = ValidGroup.Add.class) AreaDTO areaDTO) {
        return Result.success(areaService.add(areaDTO));
    }
}
