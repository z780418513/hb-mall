package com.hb.mall.admin;

import cn.hutool.core.lang.tree.Tree;
import com.alibaba.fastjson2.JSON;
import com.hb.mall.api.dto.AreaDTO;
import com.hb.mall.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhaochengshui
 * @description
 * @date: 2023/10/14 20:16
 */
@SpringBootTest
@RunWith(SpringRunner.class) // 注入失败使用这个
@ActiveProfiles("dev")
@Slf4j
public class AreaServiceTest {
    @Resource
    private AreaService areaService;

    @Test
    public void queryByAreaId(){
        AreaDTO areaDTO = areaService.queryByAreaId(110108000000L);
        Assert.assertNotNull("查询为空",areaDTO);
    }

    @Test
    public void queryListByParentAreaId(){
        List<AreaDTO> areaDTOList = areaService.queryListByParentAreaId(0L);
        Assert.assertNotNull("查询为空",areaDTOList);
        log.info("List: {}",areaDTOList);
    }

    @Test
    public void queryTreeByParentAreaId(){
        List<Tree<Long>> trees = areaService.queryTreeListByParentAreaId(0L);
        Assert.assertNotNull("查询为空",trees);
        System.out.println(JSON.toJSONString(trees));
    }
}

