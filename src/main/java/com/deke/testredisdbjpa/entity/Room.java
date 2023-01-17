package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rooms")
@Getter
@Setter
public class Room extends BaseEntity {

    private String roomType;
    private int bedCount;
    private boolean hasTv;
    private boolean hasMiniBar;
    private boolean hasGameConsole;
    private double meterSquare;
    private boolean hasSafe;
    private boolean hasProjector;


}
