package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.RoomRequestDto;
import com.deke.testredisdbjpa.entity.Room;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/room")
public class RoomController {


    @Autowired
    private RoomService roomService;

    @PostMapping(path = "/create-room")
    public ResponseEntity<RestResponseEntity<Room>> createRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(RestResponseEntity.response(roomService.addRoom(roomRequestDto)));
    }
}
