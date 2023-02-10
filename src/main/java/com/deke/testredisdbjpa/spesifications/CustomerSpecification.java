package com.deke.testredisdbjpa.spesifications;

import com.deke.testredisdbjpa.dto.search.CustomerSearchDto;
import com.deke.testredisdbjpa.entity.Customer;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerSpecification {
    public Specification<Customer> search(CustomerSearchDto customerSearchDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            List<String> fields = Arrays.stream
                    (Customer.class.getDeclaredFields()).map(Field::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            if (ObjectUtils.isNotEmpty(customerSearchDto.getName()))

                predicates.add
                        (criteriaBuilder.like(criteriaBuilder.lower(root.get(fields.get(0))
                        ), "%" + customerSearchDto.getName().toLowerCase() + "%"));
            

            if (ObjectUtils.isNotEmpty(customerSearchDto.getEmail()))
                predicates.add(criteriaBuilder.like(root.get(fields.get(1)), "%" + customerSearchDto.getEmail().toLowerCase() + "%"));

            if (ObjectUtils.isNotEmpty(customerSearchDto.getPhone()))
                predicates.add(criteriaBuilder.like(root.get(fields.get(2)), "%" + customerSearchDto.getPhone().toLowerCase() + "%"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };


    }
}
