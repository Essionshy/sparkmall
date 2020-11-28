/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tingyu.sparkmall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.tingyu.sparkmall.admin.modules.job.feign"})
@EnableDiscoveryClient
@SpringBootApplication
public class SparkmallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallAdminApplication.class, args);
    }

}