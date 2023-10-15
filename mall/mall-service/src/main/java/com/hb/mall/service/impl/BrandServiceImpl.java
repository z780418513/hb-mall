package com.hb.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.mall.api.dto.BrandDTO;
import com.hb.mall.dao.PageUtil;
import com.hb.mall.dao.entity.BrandModel;
import com.hb.mall.dao.mapper.BrandMapper;
import com.hb.mall.service.BrandService;
import com.hb.mall.service.convert.BrandConvertMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandModel> implements BrandService {
    @Resource
    private BrandConvertMapper brandConvertMapper;

    @Override
    public BrandDTO queryById(Long brandId) {
        BrandModel brandModel = baseMapper.selectById(brandId);
        return brandConvertMapper.toTarget(brandModel);
    }

    @Override
    public Page<BrandDTO> queryPage(PageDTO<BrandDTO> page) {
        Page<BrandModel> brandModelPage = baseMapper
                .selectPage(new Page<>(page.getCurrent(), page.getSize()), new QueryWrapper<>());
        return PageUtil.convertPage(brandModelPage,
                brandModelList -> brandConvertMapper.toTargetList(brandModelList));
    }
}
