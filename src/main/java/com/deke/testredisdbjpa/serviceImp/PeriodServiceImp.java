package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.Period;
import com.deke.testredisdbjpa.repositories.PeriodRepository;
import com.deke.testredisdbjpa.service.PeriodService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.stereotype.Service;

@Service
public class PeriodServiceImp extends BaseServiceImp<Period,Period, PeriodRepository, Period> implements PeriodService {
}
