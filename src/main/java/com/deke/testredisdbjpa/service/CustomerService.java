package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


@Component

public interface CustomerService extends BaseService<Customer,String> {
    Customer addCustomer(CustomerRequestDto customerRequestDto);
}
