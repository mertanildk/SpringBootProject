package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.HotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.HotelRoom;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;


@Component
public interface HotelRoomService extends BaseService<HotelRoom,String> {

    HotelRoom addHotelRoom(HotelRoomRequestDto hotelRoomRequestDto);
}
