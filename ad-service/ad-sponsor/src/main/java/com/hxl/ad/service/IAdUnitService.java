package com.hxl.ad.service;

import com.hxl.ad.exception.AdException;
import com.hxl.ad.vo.*;

/**
 * @Description: 推广单元关联 接口
 * @Author: hanxuanliang
 * @Date: 2020/2/21 15:22
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;
}

