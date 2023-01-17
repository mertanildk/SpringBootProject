package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PricingRepository extends BaseRepository<Pricing> {
}
