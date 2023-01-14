package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface FacilityService extends BaseService<Facility, String> {

    List<Facility> getBySpesiciations(List<String> spesiciations);

    List<Facility> saveAllFacilities(List<String> spesifications);

    List<String> getSpesiciation();

    List<Facility> findAllByIdList(List<String> featureIds);

}
