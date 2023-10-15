package com.hb.mall.service.convert;

import com.hb.mall.api.dto.BrandDTO;
import com.hb.mall.dao.entity.BrandModel;
import org.mapstruct.Mapper;

/**
 * @author: zhaochengshui
 * @description
 * @date: 2023/10/15 10:33
 */
@Mapper(componentModel = "spring")
public interface BrandConvertMapper extends BaseConvertMapper<BrandModel, BrandDTO>{
}
