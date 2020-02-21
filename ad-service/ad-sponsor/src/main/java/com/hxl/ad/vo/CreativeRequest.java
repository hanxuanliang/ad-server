package com.hxl.ad.vo;

import com.hxl.ad.constant.CommonStatus;
import com.hxl.ad.entity.AdCreative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 创意请求对象
 * @Author: hanxuanliang
 * @Date: 2020/2/21 15:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeRequest {

    private String name;

    private Integer type;

    private Integer materialType;

    private Integer height;

    private Integer width;

    private Long size;

    private Integer duration;

    private Long userId;

    private String url;

    public AdCreative convertToEntity() {

        AdCreative creative = new AdCreative();
        creative.setName(name);
        creative.setType(type);
        creative.setMaterialType(materialType);
        creative.setHeight(height);
        creative.setWidth(width);
        creative.setSize(size);
        creative.setDuration(duration);
        creative.setAuditStatus(CommonStatus.VALID.getStatus());
        creative.setUserId(userId);
        creative.setUrl(url);
        creative.setCreateTime(new Date());
        creative.setUpdateTime(creative.getCreateTime());

        return creative;
    }
}

