package com.hxl.ad.client;

import com.hxl.ad.client.vo.AdPlanGetRequest;
import com.hxl.ad.domain.AdPlan;
import com.hxl.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: 使用Feign调用ad-sponsor的接口
 * @Author: hanxuanliang
 * @Date: 2020/2/21 18:24
 */
@FeignClient(value = "eureka-client-ad-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "/sponsor/get/plan", method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);
}
