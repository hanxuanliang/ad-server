package com.hxl.ad.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdCreative {

    private Long adId;

    private String name;

    private Integer type;

    private Integer materialType;

    private Integer height;

    private Integer width;

    private Integer auditStatus;

    private String adUrl;

}
