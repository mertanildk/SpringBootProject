package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.entity.dto.request.CustomerRequestDto;
import com.deke.testredisdbjpa.entity.dto.search.CustomerSearchDto;
import com.deke.testredisdbjpa.repositories.CustomerRepository;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import com.deke.testredisdbjpa.utils.modelMapper.ModelMapperService;
import com.deke.testredisdbjpa.utils.passwordHash.argon2Password.PasswordHashedService;
import com.deke.testredisdbjpa.utils.spesifications.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp extends BaseServiceImp<Customer,Customer, CustomerRepository,Customer> implements CustomerService {

    private final PasswordHashedService argon2Password;
    private final ModelMapperService modelMapper;
    private final CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.forClass().map(customerRequestDto, Customer.class);
        customer.setPassword(argon2Password.hashPassword(customerRequestDto.getPassword()));
        return insert(customer);
    }
    @Override
    public List<Customer> searchAllCustomers(CustomerSearchDto customerSearchDto){
        return customerRepository.findAll(Specification.anyOf(new CustomerSpecification().search(customerSearchDto)));

    }
}
