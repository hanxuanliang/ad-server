package com.hxl.ad.service;

import com.hxl.ad.vo.CreativeRequest;
import com.hxl.ad.vo.CreativeResponse;

/**
 * @Description: 创意 接口
 * @Author: hanxuanliang
 * @Date: 2020/2/21 15:09
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}

