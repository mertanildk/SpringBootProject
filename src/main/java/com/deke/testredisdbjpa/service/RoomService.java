package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.dto.request.RoomRequestDto;
import com.deke.testredisdbjpa.entity.Room;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;


@Component
public interface RoomService extends BaseService<Room,String> {

    Room addRoom(RoomRequestDto roomRequestDto);
}
