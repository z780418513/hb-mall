package com.hb.mall.service.convert;


import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.dao.entity.AreaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author: zhaochengshui
 * @description area转换器
 * @date: 2023/10/14 16:15
 */
@Mapper(componentModel = "spring")
public interface AreaConvert {
    AreaConvert MAPPER = Mappers.getMapper(AreaConvert.class);

    AreaDTO targetDto(AreaModel areaModel);
    List<AreaDTO> targetDtoList(List<AreaModel> areaModel);
}
