package com.hxl.ad.service.impl;

import com.hxl.ad.constant.CommonStatus;
import com.hxl.ad.dao.CreativeRepository;
import com.hxl.ad.entity.AdCreative;
import com.hxl.ad.service.ICreativeService;
import com.hxl.ad.vo.CreativeRequest;
import com.hxl.ad.vo.CreativeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 创意 接口实现类
 * @Author: hanxuanliang
 * @Date: 2020/2/21 15:12
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        AdCreative creative = new AdCreative();
        BeanUtils.copyProperties(request, creative);
        creative.setAuditStatus(CommonStatus.VALID.getStatus());
        creative.setUpdateTime(creative.getCreateTime());
        creative = creativeRepository.save(creative);

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}

