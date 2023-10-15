package com.hb.mall.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: zhaochengshui
 * @description
 * @date: 2023/10/15 10:24
 */
@Data
public class BrandDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 图片路径
     */
    private String brandPic;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 默认是1，表示正常状态,0为下线状态
     */
    private Integer status;

    /**
     * 简要描述
     */
    private String brief;

    /**
     * 内容
     */
    private String content;

    /**
     * 记录时间
     */
    private Date recTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 品牌首字母
     */
    private String firstChar;

}
