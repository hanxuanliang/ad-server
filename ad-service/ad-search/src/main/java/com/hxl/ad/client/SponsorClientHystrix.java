package com.hxl.ad.client;

import com.hxl.ad.client.vo.AdPlan;
import com.hxl.ad.client.vo.AdPlanGetRequest;
import com.hxl.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 发生错误时会服务降级，就会调用此类的方法
 * @Author: hanxuanliang
 * @Date: 2020/2/21 18:34
 */
@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
