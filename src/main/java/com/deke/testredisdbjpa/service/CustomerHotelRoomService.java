package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.CustomerHotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.CustomerHotelRoom;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

@Component
public interface CustomerHotelRoomService extends BaseService<CustomerHotelRoom,String> {
    CustomerHotelRoom rentARoom(CustomerHotelRoomRequestDto customerHotelRoom);
    Pricing test(String id);
    String calculatePrice(String id);
}
