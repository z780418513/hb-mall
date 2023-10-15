package com.hb.mall.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Range(min = 0, max = 32)
    private Long id;

    /**
     * 地区名
     */
    @NotBlank
    @Length(min = 0, max = 16)
    private String areaName;

    /**
     * 父id
     */
    @NotNull
    private Long parentId;

    /**
     * 级别
     */
    @NotNull
    @Range(min = 0, max = 3)
    private Integer level;
}
