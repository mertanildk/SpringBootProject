package com.deke.testredisdbjpa.serviceImp;


import com.deke.testredisdbjpa.dto.request.CreateHotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.request.HotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelFeatureResponseDto;
import com.deke.testredisdbjpa.entity.HotelFeature;
import com.deke.testredisdbjpa.repositories.HotelFeatureRepository;
import com.deke.testredisdbjpa.service.HotelFeatureService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("hotelFeatureService")
public class HotelFeatureServiceImp extends BaseServiceImp<HotelFeature, HotelFeature, HotelFeatureRepository, HotelFeature> implements HotelFeatureService {


    private final HotelFeatureRepository hotelFeatureRepository;

    public HotelFeatureServiceImp(HotelFeatureRepository hotelFeatureRepository) {
        this.hotelFeatureRepository = hotelFeatureRepository;
    }


    @Override
    public List<HotelFeature> addHotelFeature(CreateHotelFeatureRequestDto createHotelFeatureRequestDto) {
        return Collections.emptyList();
    }

    @Override
    @Cacheable(value = "hotelFeature", key = "#hotelId")
    public List<HotelFeature> findAllByHotelId(String hotelId) {
        return hotelFeatureRepository.findAllByHotel(hotelId);
    }

    @Override
    @CacheEvict(value = "hotelFeature", key = "#hotelId")
    public List<HotelFeature> updateHotelFeature(String hotelId, HotelFeatureRequestDto hotelFeatureRequestDto) {
        return Collections.emptyList();


    }

    @Override
    public HotelFeatureResponseDto showHotelFeatures(String hotelId){
        return null;
    }
}
