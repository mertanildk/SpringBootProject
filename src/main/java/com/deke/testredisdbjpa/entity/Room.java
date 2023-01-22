package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name="rooms")
@Getter
@Setter
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
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
