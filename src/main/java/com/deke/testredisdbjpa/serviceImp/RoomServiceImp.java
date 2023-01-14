package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.RoomRequestDto;
import com.deke.testredisdbjpa.entity.Room;
import com.deke.testredisdbjpa.repositories.RoomRepository;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.service.RoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImp extends BaseServiceImp<Room, Room, RoomRepository, Room> implements RoomService {

    @Autowired
    private HotelService hotelService;
    @Override
    public Room addRoom(RoomRequestDto roomRequestDto) {
        Room room = new Room();
        room.setBedCount(roomRequestDto.getBedCount());
        room.setRoomType(roomRequestDto.getRoomType());
        room.setHasTv(roomRequestDto.isHasTv());
        room.setHasMiniBar(roomRequestDto.isHasMiniBar());
        room.setHasGameConsole(roomRequestDto.isHasGameConsole());
        room.setMeterSquare(roomRequestDto.getMeterSquare());
        room.setHasSafe(roomRequestDto.isHasSafe());
        room.setHasProjector(roomRequestDto.isHasProjector());
        getDao().save(room);
        return room;
    }
}
