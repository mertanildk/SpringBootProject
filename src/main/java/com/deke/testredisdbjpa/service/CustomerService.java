package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.entity.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.dto.search.CustomerSearchDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService extends BaseService<Customer,String> {
    Customer addCustomer(CustomerRequestDto customerRequestDto);
    List<Customer> searchAllCustomers(CustomerSearchDto customerSearchDto);
}
