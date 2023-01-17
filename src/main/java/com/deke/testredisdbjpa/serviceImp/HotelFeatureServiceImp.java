package com.deke.testredisdbjpa.serviceImp;


import com.deke.testredisdbjpa.dto.request.CreateHotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.request.HotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelFeatureResponseDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.entity.HotelFeature;
import com.deke.testredisdbjpa.repositories.HotelFeatureRepository;
import com.deke.testredisdbjpa.service.FacilityService;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.service.HotelFeatureService;

import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("hotelFeatureService")
public class HotelFeatureServiceImp extends BaseServiceImp<HotelFeature, HotelFeature, HotelFeatureRepository, HotelFeature> implements HotelFeatureService {

    @Autowired
    private HotelFeatureRepository hotelFeatureRepository;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private HostelTypeService hostelTypeService;

    @Autowired
    private HotelService hotelService;


    @Override
    public List<HotelFeature> addHotelFeature(CreateHotelFeatureRequestDto createHotelFeatureRequestDto) {
        return null;
    }

    @Override
    @Cacheable(value = "hotelFeature", key = "#hotelId")
    public List<HotelFeature> findAllByHotelId(String hotelId) {
        return hotelFeatureRepository.findAllByHotel(hotelId);
    }

    @Override
    @CacheEvict(value = "hotelFeature", key = "#hotelId")
    public List<HotelFeature> updateHotelFeature(String hotelId, HotelFeatureRequestDto hotelFeatureRequestDto) {
        return null;


    }

    @Override
    public HotelFeatureResponseDto showHotelFeatures(String hotelId){
        return null;
    }
}
