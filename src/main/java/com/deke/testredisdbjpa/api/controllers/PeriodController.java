package com.deke.testredisdbjpa.api.controllers;


import com.deke.testredisdbjpa.entity.Period;
import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/period")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @PostMapping(path = "/create-period")
    public ResponseEntity<RestResponseEntity<Period>> createPeriod(@RequestBody Period period){
        return ResponseEntity.ok(RestResponseEntity.response(periodService.insert(period)));

    }
}
