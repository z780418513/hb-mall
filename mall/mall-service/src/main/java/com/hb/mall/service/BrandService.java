package com.hb.mall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hb.mall.api.dto.BrandDTO;
import com.hb.mall.dao.entity.BrandModel;

public interface BrandService extends IService<BrandModel>{

    BrandDTO queryById(Long brandId);

    Page<BrandDTO> queryPage(PageDTO<BrandDTO> page);
}
