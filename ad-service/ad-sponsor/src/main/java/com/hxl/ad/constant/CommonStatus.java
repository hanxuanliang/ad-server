package com.hxl.ad.constant;

import lombok.Getter;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:39
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}

