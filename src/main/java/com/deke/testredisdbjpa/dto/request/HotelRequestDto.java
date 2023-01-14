package com.deke.testredisdbjpa.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter @Setter
public class HotelRequestDto implements Serializable {

    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;
}
