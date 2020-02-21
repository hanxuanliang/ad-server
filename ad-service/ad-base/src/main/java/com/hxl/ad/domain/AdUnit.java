package com.hxl.ad.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnit {

    private Long unitId;

    private Integer unitStatus;

    private Integer positionType;

    private Long planId;
}
