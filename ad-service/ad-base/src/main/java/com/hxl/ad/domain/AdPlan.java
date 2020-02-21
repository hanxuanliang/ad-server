package com.hxl.ad.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlan {

    private Long id;

    private Long userId;

    private Integer planStatus;

    private Date startDate;

    private Date endDate;

}
