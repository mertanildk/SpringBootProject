package com.deke.testredisdbjpa.api.controllers;


import com.deke.testredisdbjpa.entity.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.entity.dto.search.HotelSearchDto;
import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.HotelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/hotel")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping(path = "/create-hotel")
    public ResponseEntity createHotel(@RequestBody @Valid CreateHotelRequestDto createHotelRequestDto) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.addHotel(createHotelRequestDto)));
    }

    @GetMapping(path = "/get-hotel-by-id/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.findOne(id)));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity getByIdDTO(@PathVariable String id) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.getHotelDTO(id)));
    }

    @PostMapping(value = "/search-hotel-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchHotelAll(@RequestBody HotelSearchDto hotelSearchDto) {
        return ResponseEntity.ok(RestResponseEntity.response(hotelService.searchAllHotels(hotelSearchDto)));
    }
}
