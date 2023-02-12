package com.deke.testredisdbjpa.api.controllers;


import com.deke.testredisdbjpa.entity.dto.request.PricingRequestDto;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @PostMapping(path = "/create-pricing")
    public ResponseEntity<RestResponseEntity<Pricing>> createPricing(@RequestBody PricingRequestDto pricing) {
        return ResponseEntity.ok(RestResponseEntity.response(pricingService.addPricing(pricing)));

    }
    @GetMapping(path = "/get-pricing-by-id/{id}")
    public ResponseEntity<RestResponseEntity<Pricing>> getPricingById(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(pricingService.getPricingDetailById(id)));
    }
}
