package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.HotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.HotelRoom;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.HotelRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel-room")
public class HotelRoomController {
    private final HotelRoomService hotelRoomService;
    public HotelRoomController(HotelRoomService hotelRoomService) {this.hotelRoomService = hotelRoomService;}


    @PostMapping("/create")
    public ResponseEntity<RestResponseEntity<HotelRoom>> createHotelRoom(@RequestBody HotelRoomRequestDto hotelRoom) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelRoomService.addHotelRoom(hotelRoom)));
    }

}
