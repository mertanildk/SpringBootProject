package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelResponseDto;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.HotelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/hotel")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping(path = "/create-hotel")
    public ResponseEntity<RestResponseEntity<HotelResponseDto>> createHotel(@RequestBody @Valid CreateHotelRequestDto createHotelRequestDto) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.addHotel(createHotelRequestDto)));
    }

    @GetMapping(path = "/get-hotel-by-id/{id}")
    public ResponseEntity<RestResponseEntity<HotelResponseDto>> getById(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.findOne(id)));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<RestResponseEntity<CreateHotelRequestDto>> getByIdDTO(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.getHotelDTO(id)));
    }
}
