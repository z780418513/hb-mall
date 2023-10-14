package com.hb.mall.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Schema
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "area")
public class AreaModel implements Serializable {
    /**
     * 地区id
     */
    @TableId(value = "area_id", type = IdType.INPUT)
    @Schema(description="地区id")
    @NotNull(message = "地区id不能为null")
    private Long areaId;

    /**
     * 地区名
     */
    @TableField(value = "area_name")
    @Schema(description="地区名")
    @Size(max = 50,message = "地区名最大长度要小于 50")
    private String areaName;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    @Schema(description="父id")
    private Long parentId;

    /**
     * 级别
     */
    @TableField(value = "`level`")
    @Schema(description="级别")
    private Integer level;

    private static final long serialVersionUID = 1L;
}
