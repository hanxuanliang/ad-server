package com.hxl.ad.dao;

import com.hxl.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 用户表 repository
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:58
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * <h2>根据用户名查找用户记录</h2>
     * @param username 用户名
     * @return AdUser
     * @date: 2020/2/21 14:01
     */
    AdUser findByUsername(String username);
}

