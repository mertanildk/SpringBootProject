package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.CreateHotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.request.HotelFeatureRequestDto;
import com.deke.testredisdbjpa.entity.HotelFeature;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HotelFeatureService extends BaseService<HotelFeature, String> {


    List<HotelFeature> addHotelFeature(CreateHotelFeatureRequestDto createHotelFeatureRequestDto);

    List<HotelFeature> findAllByHotelId(String hotelId);
    List<HotelFeature> updateHotelFeature(String hotelId, HotelFeatureRequestDto hotelFeatureRequestDto);
}
