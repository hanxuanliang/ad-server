package com.hxl.ad.service;

import com.hxl.ad.entity.AdPlan;
import com.hxl.ad.exception.AdException;
import com.hxl.ad.vo.AdPlanGetRequest;
import com.hxl.ad.vo.AdPlanRequest;
import com.hxl.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @Description: 推广计划 接口
 * @Author: hanxuanliang
 * @Date: 2020/2/21 14:44
 */
public interface IAdPlanService {

    /**
     * <h2>创建推广计划</h2>
     * @date: 2020/2/21 14:48
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>获取推广计划</h2>
     * @date: 2020/2/21 14:47
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * <h2>更新推广计划</h2>
     * @date: 2020/2/21 14:48
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>删除推广计划</h2>
     * @date: 2020/2/21 14:48
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
