package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.dto.request.FacilityRequestDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.utils.exceptions.NullInputException;
import com.deke.testredisdbjpa.repositories.FacilityRepository;
import com.deke.testredisdbjpa.service.FacilityService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("facilityService")
public class FacilityServiceImp extends BaseServiceImp<Facility, Facility, FacilityRepository, Facility> implements FacilityService {


    private final FacilityRepository facilityRepository;
    private final ModelMapper modelMapper;

    public FacilityServiceImp(FacilityRepository facilityRepository, ModelMapper modelMapper) {
        this.facilityRepository = facilityRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Facility> saveAllFacilities(List<FacilityRequestDto> facilityRequestDtos) {
        facilityRequestDtos.stream().map(s -> modelMapper.map(s, Facility.class)).forEach(facilityRepository::save);
        return getDao().findAll();
    }

    @Override
    public Facility deleteById(String id) {
        Facility facility = getDao().findById(id).orElseThrow(NullInputException::new);
        facility.setDeleted(new Date());
        facilityRepository.delete(facility);
        return facility;
    }
}