package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.CustomerHotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.CustomerHotelRoom;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.CustomerHotelRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-hotel-room")
public class CustomerHotelRoomController {


    private final CustomerHotelRoomService customerHotelRoomService;

    public CustomerHotelRoomController(CustomerHotelRoomService customerHotelRoomService) {
        this.customerHotelRoomService = customerHotelRoomService;
    }

    @PostMapping("/rent-a-room")
    public ResponseEntity rentARoom(@RequestBody CustomerHotelRoomRequestDto customerHotelRoom){
        return ResponseEntity.ok(RestResponseEntity.response(customerHotelRoomService.rentARoom(customerHotelRoom)));
    }
}
