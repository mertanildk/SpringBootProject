package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.dto.search.CustomerSearchDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.repositories.CustomerRepository;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import com.deke.testredisdbjpa.spesifications.CustomerSpecification;
import com.deke.testredisdbjpa.utils.HashingUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp extends BaseServiceImp<Customer,Customer, CustomerRepository,Customer> implements CustomerService {

    private final Argon2PasswordEncoder encoder;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        customer.setPassword(HashingUtil.hashSHA2(customerRequestDto.getPassword()));
        return insert(customer);
    }
    @Override
    public List<Customer> searchAllCustomers(CustomerSearchDto customerSearchDto){
        return customerRepository.findAll(Specification.anyOf(new CustomerSpecification().search(customerSearchDto)));

    }
}
