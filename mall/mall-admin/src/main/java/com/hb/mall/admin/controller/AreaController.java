package com.hb.mall.admin.controller;

import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.common.core.Result;
import com.hb.mall.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public Result<AreaDTO> queryByAreaId(@RequestParam Long areaId) {
        return Result.success(areaService.queryByAreaId(areaId));
    }
}
