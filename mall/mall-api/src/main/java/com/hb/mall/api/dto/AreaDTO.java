package com.hb.mall.api.dto;

import lombok.Data;

/**
 * @author: zhaochengshui
 * @description
 * @date: 2023/10/14 15:55
 */
@Data
public class AreaDTO {

    /**
     * 地区id
     */
    private Long id;

    /**
     * 地区名
     */
    private String areaName;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 级别
     */
    private Integer level;
}
