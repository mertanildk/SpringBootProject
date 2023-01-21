package com.deke.testredisdbjpa.dto.request;


import lombok.Getter;

@Getter
public class HotelRoomRequestDto {
    private String hotelId;
    private String roomId;
    private int roomCount;
}
