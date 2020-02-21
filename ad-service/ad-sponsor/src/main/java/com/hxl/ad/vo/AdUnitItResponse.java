package com.hxl.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 推广单元兴趣返回结果对象
 * @Author: hanxuanliang
 * @Date: 2020/2/21 15:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItResponse {

    private List<Long> ids;
}

