package com.deke.testredisdbjpa.dto.request;


import com.deke.testredisdbjpa.entity.Customer;
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
