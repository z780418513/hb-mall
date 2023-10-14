package com.hb.mall.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: zhaochengshui
 * @description
 * @date: 2023/10/14 15:55
 */
@Data
@Schema(name="AreaDTO",description ="AreaDTO" )
public class AreaDTO {

    /**
     * 地区id
     */
    @Schema(name="areaId",description ="地区id" )
    private Long areaId;

    /**
     * 地区名
     */
    @Schema(name="areaName",description ="地区名" )
    private String areaName;

    /**
     * 父id
     */
    @Schema(name="parentId",description ="父id" )
    private Long parentId;

    /**
     * 级别
     */
    @Schema(name="level",description ="级别" )
    private Integer level;
}
