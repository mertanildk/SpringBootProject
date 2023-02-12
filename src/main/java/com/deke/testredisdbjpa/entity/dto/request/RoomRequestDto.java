package com.deke.testredisdbjpa.entity.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomRequestDto {

    private String roomType;
    private int bedCount;
    private boolean hasTv;
    private boolean hasMiniBar;
    private boolean hasGameConsole;
    private double meterSquare;
    private boolean hasSafe;
    private boolean hasProjector;
}
