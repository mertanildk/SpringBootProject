package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.FacilityRequestDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @PostMapping("/create-facilities")
    public ResponseEntity<RestResponseEntity<List<Facility>>> createFacilities(@RequestBody List<FacilityRequestDto> facilityRequestDtos) {
        return ResponseEntity.ok(RestResponseEntity.response(facilityService.saveAllFacilities(facilityRequestDtos)));
    }

    @GetMapping("/get-all-facilities")
    public ResponseEntity<RestResponseEntity<List<String>>> getAllFacilities() {
        return ResponseEntity.ok(RestResponseEntity.response(facilityService.findAll()));
    }

    @GetMapping("/test")
    public void test() {
        facilityService.testMethod2("deke");
    }
}
