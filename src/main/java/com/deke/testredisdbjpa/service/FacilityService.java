package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.entity.dto.request.FacilityRequestDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface FacilityService extends BaseService<Facility, String> {

    List<Facility> saveAllFacilities(List<FacilityRequestDto> facilityRequestDtos);
    Facility deleteById(String id);

}
