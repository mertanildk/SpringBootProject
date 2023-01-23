package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends BaseRepository<Customer> {
}
