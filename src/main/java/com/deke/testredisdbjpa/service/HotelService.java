package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;


@Component
public interface HotelService extends BaseService<Hotel, String> {

    boolean deleteHotel(String id);

    Hotel addHotel(CreateHotelRequestDto createHotelRequestDto);

    CreateHotelRequestDto getHotelDTO(String id);
}
