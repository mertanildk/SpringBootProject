package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.HotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.HotelRoom;
import com.deke.testredisdbjpa.repositories.HotelRoomRepository;
import com.deke.testredisdbjpa.service.HotelRoomService;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.service.RoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class HotelRoomServiceImp extends BaseServiceImp<HotelRoom,HotelRoom, HotelRoomRepository,HotelRoom> implements HotelRoomService {

    private final HotelService hotelService;
    private final RoomService roomService;

    public HotelRoomServiceImp(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }


    @Override
    @SneakyThrows
    public HotelRoom addHotelRoom(HotelRoomRequestDto hotelRoomRequestDto) {
        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setHotel(hotelService.findOne(hotelRoomRequestDto.getHotelId()).orElseThrow(()->new Exception("Hotel not found")));
        hotelRoom.setRoom(roomService.findOne(hotelRoomRequestDto.getRoomId()).orElseThrow(()->new Exception("Room not found")));
        hotelRoom.setRoomCount(hotelRoomRequestDto.getRoomCount());
        return getDao().save(hotelRoom);
    }
}
