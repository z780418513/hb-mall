package com.hb.mall.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "area")
public class AreaModel implements Serializable {
    /**
     * 地区id
     */
    @TableId(value = "area_id", type = IdType.INPUT)
    private Long areaId;

    /**
     * 地区名
     */
    @TableField(value = "area_name")
    private String areaName;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 级别
     */
    @TableField(value = "`level`")
    private Integer level;

    private static final long serialVersionUID = 1L;
}
