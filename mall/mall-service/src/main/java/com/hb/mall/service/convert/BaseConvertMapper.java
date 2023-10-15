package com.hb.mall.service.convert;


import java.util.List;

/**
 * @author: zhaochengshui
 * @description 基础Mapper转换器
 * @date: 2023/10/15 11:12
 */
public interface BaseConvertMapper<S, T> {

    T toTarget(S s);

    S toSource(T t);

    List<T> toTargetList(List<S> s);

    List<S> toSourceList(List<T> t);
}
