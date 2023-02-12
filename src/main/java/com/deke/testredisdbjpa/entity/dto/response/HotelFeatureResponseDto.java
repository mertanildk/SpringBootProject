package com.deke.testredisdbjpa.entity.dto.response;

import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.entity.HostelType;
import com.deke.testredisdbjpa.entity.Hotel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
public class HotelFeatureResponseDto{

    private Hotel hotel;
    private List<HostelType> hostelTypes;
    private List<Facility> facilities;

}
