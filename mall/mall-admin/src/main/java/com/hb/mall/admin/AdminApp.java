package com.hb.mall.admin;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhaochengshui
 * @description 启动类
 * @date: 2023/10/14 14:44
 */
@EnableDiscoveryClient // nacos
@EnableKnife4j // swagger
@MapperScan("com.hb.*.dao.mapper")
@SpringBootApplication(scanBasePackages = {"com.hb.mall"})
public class AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }
}
