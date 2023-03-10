package com.deke.testredisdbjpa.api.controllers;

import com.deke.testredisdbjpa.Aop.Log;
import com.deke.testredisdbjpa.Aop.LogType;
import com.deke.testredisdbjpa.entity.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.dto.search.CustomerSearchDto;
import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    @Log(LogType.WRITE)
    public ResponseEntity addCustomer(@RequestBody @Valid CustomerRequestDto customer) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.addCustomer(customer)));
    }

    @GetMapping("/get/{id}")
    @Log
    public ResponseEntity getCustomer(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.getOne(id)));
    }

    @Log(LogType.WRITE)
    @PostMapping(value = "/search-all-customers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAllCustomers(@RequestBody CustomerSearchDto customerSearchDto) {
        return ResponseEntity.ok(RestResponseEntity.response(customerService.searchAllCustomers(customerSearchDto)));
    }

}
