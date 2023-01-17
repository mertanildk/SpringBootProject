package com.deke.testredisdbjpa.service;


import com.deke.testredisdbjpa.dto.request.PricingRequestDto;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

@Component
public interface PricingService extends BaseService<Pricing, String> {

    String getPricingDetailById(String id);
    Pricing addPricing(PricingRequestDto pricingRequestDto);
}
