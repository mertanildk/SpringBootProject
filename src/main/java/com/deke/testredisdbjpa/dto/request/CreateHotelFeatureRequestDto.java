package com.deke.testredisdbjpa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateHotelFeatureRequestDto {
    List<String> facilityIds;
    List<String> hostelTypeIds;
    String hotelId;
}
