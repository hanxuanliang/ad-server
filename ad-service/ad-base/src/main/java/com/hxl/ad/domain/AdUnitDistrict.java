package com.hxl.ad.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitDistrict {

    private Long unitId;

    private String province;

    private String city;

}
