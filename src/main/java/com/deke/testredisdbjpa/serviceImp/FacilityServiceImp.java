package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.FacilityRequestDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.repositories.FacilityRepository;
import com.deke.testredisdbjpa.service.FacilityService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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



    /*
    Aop Testini Bu Methodda Yapıyorum @Before After Gibi Methodlar Çalışıyor Silme
     */
    @Override
    public String testMethod2(String name){
        return "testMethod2";
    }
}