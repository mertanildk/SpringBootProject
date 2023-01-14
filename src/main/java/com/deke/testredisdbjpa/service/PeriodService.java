package com.deke.testredisdbjpa.service;


import com.deke.testredisdbjpa.entity.Period;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

@Component
public interface PeriodService extends BaseService<Period, String> {
}
