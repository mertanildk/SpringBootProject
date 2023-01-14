package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.FacilityRepository;
import com.deke.testredisdbjpa.service.FacilityService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("facilityService")
public class FacilityServiceImp extends BaseServiceImp<Facility, Facility, FacilityRepository, Facility> implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;


    @Override
    public List<Facility> getBySpesiciations(List<String> spesiciations) {
        List<Facility> facilities = new ArrayList<>();
        spesiciations.forEach(spesification ->facilities.add(facilityRepository.getBySpesification(spesification)));
        return facilities;
    }

    @Override
    public List<Facility> saveAllFacilities(List<String> spesifications) {
        List<Facility> facilities = new ArrayList<>();
        spesifications.forEach(spesification -> {
            Facility facility = new Facility();
            facility.setSpecifications(spesification);
            facilities.add(facility);
        });
        facilityRepository.saveAll(facilities);
        return facilities;
    }

    @Override
    public List<String> getSpesiciation() {
        Iterable<Facility> facilities = findAll();
        List<String> spesiciationList = new ArrayList<>();
        facilities.forEach(spesiciation -> spesiciationList.add(spesiciation.getSpecifications()));
        return spesiciationList;
    }

    @Override
    public List<Facility> findAllByIdList(List<String> featureIds) {
        return facilityRepository.findAllById(featureIds);
    }

}
