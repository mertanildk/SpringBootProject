package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.repositories.CustomerRepository;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp extends BaseServiceImp<Customer,Customer, CustomerRepository,Customer> implements CustomerService {

    private final ModelMapper modelMapper;
    @Override
    public Customer addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        return insert(customer);
    }
}
