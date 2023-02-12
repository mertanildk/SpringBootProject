package com.deke.testredisdbjpa.api.controllers;


import com.deke.testredisdbjpa.entity.dto.request.CreateHotelFeatureRequestDto;
import com.deke.testredisdbjpa.entity.dto.request.HotelFeatureRequestDto;
import com.deke.testredisdbjpa.entity.dto.response.HotelFeatureResponseDto;
import com.deke.testredisdbjpa.entity.dto.response.HotelResponseDto;
import com.deke.testredisdbjpa.entity.HotelFeature;
import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.HotelFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hotel-feature")
public class HotelFeatureController {
    @Autowired
    private HotelFeatureService hotelFeatureService;


    @PostMapping("/create-hotel-feature")
    public ResponseEntity<RestResponseEntity<HotelResponseDto>> createHotelFeatureList(@RequestBody CreateHotelFeatureRequestDto createHotelFeatureRequestDto){
        return ResponseEntity.ok(RestResponseEntity.response(hotelFeatureService.addHotelFeature(createHotelFeatureRequestDto)));
    }

    @GetMapping("/get-by-hotel-id/{id}")
    public ResponseEntity<RestResponseEntity<List<HotelFeature>> > getByHotelId(@PathVariable String id){
        return ResponseEntity.ok(RestResponseEntity.response(hotelFeatureService.findAllByHotelId(id)));
    }
    @PostMapping("/update-hotel-feature/{id}")
    public ResponseEntity<RestResponseEntity<List<HotelFeature>>> updateHotelFeature(@PathVariable String id,
                                                                                     @RequestBody HotelFeatureRequestDto hotelFeatureRequestDto){
        return ResponseEntity.ok(RestResponseEntity.response(hotelFeatureService.updateHotelFeature(id, hotelFeatureRequestDto)));
    }

    @GetMapping("/get-all-hotel-feature-by-hotel-id/{id}")
    public ResponseEntity<RestResponseEntity<HotelFeatureResponseDto>> getHotelFeatureByHotelId(@PathVariable String id){
        return ResponseEntity.ok(RestResponseEntity.response(hotelFeatureService.showHotelFeatures(id)));
    }
}
