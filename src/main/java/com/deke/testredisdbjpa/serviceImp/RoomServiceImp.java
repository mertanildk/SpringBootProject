package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.dto.request.RoomRequestDto;
import com.deke.testredisdbjpa.entity.Room;
import com.deke.testredisdbjpa.repositories.RoomRepository;
import com.deke.testredisdbjpa.service.RoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("roomService")
public class RoomServiceImp extends BaseServiceImp<Room, Room, RoomRepository, Room> implements RoomService {


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

    @Override
    public List<Room> findByIdList(List<String> idList) {
        List<Room> roomList = new ArrayList<>();
        for (String id : idList) {
            Optional<Room> optionalRoom = getDao().findById(id);
            optionalRoom.ifPresent(roomList::add);
        }
        return roomList;
    }
}
