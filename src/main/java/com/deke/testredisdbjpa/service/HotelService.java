package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.HotelRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelResponseDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HotelService extends BaseService<Hotel, String> {

    HotelResponseDto getByHotelId(String id);
    String deleteCache(String id);

    Hotel addHotel(List<String> specification, List<String> hostelTypeName);
    HotelResponseDto updateHotel(String id, HotelRequestDto hotelRequestDto);
}
