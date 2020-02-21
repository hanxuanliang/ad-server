package com.hxl.ad.service;

import com.hxl.ad.exception.AdException;
import com.hxl.ad.vo.CreateUserRequest;
import com.hxl.ad.vo.CreateUserResponse;

/**
 * @Description: 用户 接口
 * @Author: hanxuanliang
 * @Date: 2020/2/21 14:22
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * @date: 2020/2/21 14:24
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
