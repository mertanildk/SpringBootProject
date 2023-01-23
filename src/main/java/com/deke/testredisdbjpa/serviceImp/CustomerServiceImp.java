package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.repositories.CustomerRepository;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp extends BaseServiceImp<Customer,Customer, CustomerRepository,Customer> implements CustomerService {
}
