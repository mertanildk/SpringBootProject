package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.entity.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.entity.dto.search.HotelSearchDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HotelService extends BaseService<Hotel, String> {

    boolean deleteHotel(String id);

    Hotel addHotel(CreateHotelRequestDto createHotelRequestDto);

    CreateHotelRequestDto getHotelDTO(String id);

    List<Hotel> searchAllHotels(HotelSearchDto hotelSearchDto);
}
