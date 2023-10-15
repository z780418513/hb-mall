package com.hb.mall.admin;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.hb.mall.api.dto.BrandDTO;
import com.hb.mall.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: zhaochengshui
 * @description
 * @date: 2023/10/15 11:29
 */
@SpringBootTest
@RunWith(SpringRunner.class) // 注入失败使用这个
@ActiveProfiles("dev")
@Slf4j
public class BrandServiceTest {

    @Resource
    private BrandService brandService;

    @Test
    public void queryById(){
        BrandDTO brandDTO = brandService.queryById(1L);
        System.out.println(brandDTO);
    }

    @Test
    public void queryPage(){
        Page<BrandDTO> page = brandService.queryPage(new PageDTO<>(1, 2));
        System.out.println(JSON.toJSONString(page));
    }
}
