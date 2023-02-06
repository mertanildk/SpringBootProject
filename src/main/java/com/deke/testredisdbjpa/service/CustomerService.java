package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService extends BaseService<Customer,String> {
    Customer addCustomer(CustomerRequestDto customerRequestDto);
}
