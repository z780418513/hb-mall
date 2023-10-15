package com.hb.mall.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.function.Function;

/**
 * @author: zhaochengshui
 * @description 分页工具类
 * @date: 2023/10/15 11:08
 */
public class PageUtil {

    /**
     * 分页对象类型转换
     *
     * @param source   源对象Page
     * @param function 对象转换function接口
     * @param <T>      源对象类型
     * @param <R>      目标对象类型
     * @return 转换后Page对象
     */
    public static <T, R> Page<R> convertPage(Page<T> source, Function<List<T>, List<R>> function) {
        Page<R> targetPage = new Page<>();
        targetPage.setCurrent(Math.toIntExact(source.getCurrent()));
        targetPage.setSize(Math.toIntExact(source.getSize()));
        targetPage.setTotal(Math.toIntExact(source.getTotal()));
        List<R> targetRecords = function.apply(source.getRecords());
        targetPage.setRecords(targetRecords);
        return targetPage;
    }

    private PageUtil() {
    }


}
