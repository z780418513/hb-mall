package com.hb.mall.admin.controller;

import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.service.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "AreaController", description = "地区相关接口")
public class AreaController {

    @Resource
    private AreaService areaService;

    @Operation(summary = "查询地区", description = "根据id查询地区",
            parameters = {@Parameter(name = "areaId", description = "地区ID")},
            responses = {@ApiResponse(description = "返回地区信息", content = @Content(mediaType = "application/json"))}
//                    schema = @Schema(anyOf = {CommonResult.class, User.class}))),
//                    @ApiResponse(responseCode = "400", description = "返回400时候错误的原因")

    )
    @GetMapping("/getById")
    public AreaDTO queryByAreaId(@RequestParam Long areaId) {
        return areaService.queryByAreaId(areaId);
    }
}
