package com.hxl.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description: zuul网关 主入口类
 * @Author: hanxuanliang
 * @Date: 2020/2/21 12:05
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) { SpringApplication.run(ZuulGatewayApplication.class, args); }
}
