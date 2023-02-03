package com.deke.testredisdbjpa.controllers;

import com.deke.testredisdbjpa.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<RestResponseEntity<Customer>> addCustomer(@RequestBody CustomerRequestDto customer){
        return ResponseEntity.ok(RestResponseEntity.response(customerService.addCustomer(customer)));
    }

}
