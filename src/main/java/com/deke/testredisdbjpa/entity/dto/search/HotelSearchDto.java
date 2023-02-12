package com.deke.testredisdbjpa.entity.dto.search;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class HotelSearchDto {

    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;


}
