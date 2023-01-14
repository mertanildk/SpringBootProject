package com.deke.testredisdbjpa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateHotelRequestDto {

    private String hotelName;
    private List<String> specifications;
    private List<String> hostelTypeNames;
}
