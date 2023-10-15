package com.hb.mall.service.convert;


import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.dao.entity.AreaModel;
import org.mapstruct.Mapper;

/**
 * @author: zhaochengshui
 * @description area转换器
 * @date: 2023/10/14 16:15
 */
@Mapper(componentModel = "spring")
public interface AreaConvertMapper extends BaseConvertMapper<AreaModel,AreaDTO>{
}
