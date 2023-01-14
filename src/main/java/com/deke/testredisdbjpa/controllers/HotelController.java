package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelResponseDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping(path = "/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping(path = "/create-hotel")
    public ResponseEntity<RestResponseEntity<HotelResponseDto>> createHotell(@RequestBody CreateHotelRequestDto createHotelRequestDto) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.addHotel(createHotelRequestDto)));
    }
    @GetMapping(path = "/get-hotel-by-id/{id}")
    public ResponseEntity<RestResponseEntity<HotelResponseDto>> getById(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.getByHotelId(id)));
    }
}
