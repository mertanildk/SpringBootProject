package com.deke.testredisdbjpa.entity.dto.request;


import lombok.Getter;

import java.util.Date;

@Getter
public class CustomerHotelRoomRequestDto {
    private CustomerRequestDto customerRequestDto;
    private String hotelRoomId;
    private Date entryDate;
    private Date exitDate;
    private double amount;
}
