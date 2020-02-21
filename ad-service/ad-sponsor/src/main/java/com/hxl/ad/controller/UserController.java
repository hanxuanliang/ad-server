package com.hxl.ad.controller;

import com.alibaba.fastjson.JSON;
import com.hxl.ad.exception.AdException;
import com.hxl.ad.service.IUserService;
import com.hxl.ad.vo.CreateUserRequest;
import com.hxl.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 18:49
 */
@Slf4j
@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        // @RequestBody 实现对json参数的反序列化，前提是必须是前端传过来是json字符串
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
