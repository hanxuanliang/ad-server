package com.hxl.ad.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlan {

    private Long id;

    private Long userId;

    private String planName;

    private Integer planStatus;

    private Date startDate;

    private Date endDate;

    private Date createTime;

    private Date updateTime;
}

