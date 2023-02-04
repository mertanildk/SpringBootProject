package com.deke.testredisdbjpa.controllers;

import com.deke.testredisdbjpa.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<RestResponseEntity<Customer>> addCustomer(@RequestBody CustomerRequestDto customer){
        return ResponseEntity.ok(RestResponseEntity.response(customerService.addCustomer(customer)));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<RestResponseEntity<Customer>> getCustomer(@PathVariable String id){
        return ResponseEntity.ok(RestResponseEntity.response(customerService.getOne(id)));
    }

}
