package com.hxl.ad.controller;

import com.alibaba.fastjson.JSON;
import com.hxl.ad.service.ICreativeService;
import com.hxl.ad.vo.CreativeRequest;
import com.hxl.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 19:00
 */
@Slf4j
@RestController
public class CreativeController {

    private final ICreativeService creativeService;

    @Autowired
    public CreativeController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request) {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
