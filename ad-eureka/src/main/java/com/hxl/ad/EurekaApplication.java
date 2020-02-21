package com.hxl.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: Eureka启动类
 * @Author: hanxuanliang
 * @Date: 2020/2/21 11:23
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) { SpringApplication.run(EurekaApplication.class, args); }
}
