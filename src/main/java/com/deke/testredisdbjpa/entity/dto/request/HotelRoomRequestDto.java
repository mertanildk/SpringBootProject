package com.deke.testredisdbjpa.entity.dto.request;


import lombok.Getter;

@Getter
public class HotelRoomRequestDto {
    private String hotelId;
    private String roomId;
    private int roomCount;
}
