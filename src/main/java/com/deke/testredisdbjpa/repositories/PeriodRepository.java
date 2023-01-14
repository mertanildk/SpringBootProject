package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Period;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends BaseRepository<Period> {
}
