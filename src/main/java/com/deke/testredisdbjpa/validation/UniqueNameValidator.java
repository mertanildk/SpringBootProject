package com.deke.testredisdbjpa.validation;

import com.deke.testredisdbjpa.repositories.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UniqueNameValidator implements ConstraintValidator<UniqueCustomerName,String> {

    private final CustomerRepository customerRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return customerRepository.findAll().stream().noneMatch(customer -> customer.getName().equals(name));
    }

}
