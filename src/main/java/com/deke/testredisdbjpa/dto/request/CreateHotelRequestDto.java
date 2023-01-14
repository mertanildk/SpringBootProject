package com.deke.testredisdbjpa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateHotelRequestDto {

    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;
    private List<String> roomIds;

}
