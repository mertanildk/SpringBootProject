package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @Entity
@Table(name = "pricing")
public class Pricing extends BaseEntity {

    @JoinColumn(name = "hotel_id")
    private String hotelOid;

    @JoinColumn(name="period_id")
    private String periodOid;

    @JoinColumn(name="room_id")
    private String roomOid;

    @JoinColumn(name="hostel_type_id")
    private String hostelTypeOid;

    @Column(name = "adult_price")
    private Double adultPrice;

    @Column(name = "child_price")
    private Double childPrice;

    @Column(name="money_type")
    private String moneyType;




}
