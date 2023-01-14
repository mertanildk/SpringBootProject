package com.deke.testredisdbjpa.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
public class HotelFeatureResponseDto{

    HotelResponseDto hotelResponseDto;
    private List<String> hostelType;
    private List<String> facilities;

}
