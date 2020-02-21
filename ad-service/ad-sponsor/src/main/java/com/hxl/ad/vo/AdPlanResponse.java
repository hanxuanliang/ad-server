package com.hxl.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 推广计划返回结果对象
 * @Author: hanxuanliang
 * @Date: 2020/2/21 14:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanResponse {

    private Long id;

    private String planName;
}
