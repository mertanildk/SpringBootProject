package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter @Setter @Entity
@Table(name = "pricing")
@AllArgsConstructor
@NoArgsConstructor
public class Pricing extends BaseEntity {

    @JoinColumn(name = "hotel_id")
    @OneToOne
    private Hotel hotel;

    @JoinColumn(name="period_id")
    @OneToOne
    private Period period;

    @JoinColumn(name="room_id")
    @OneToOne
    private Room room;

    @JoinColumn(name="hostel_type_id")
    @OneToOne
    private HostelType hostelType;

    @Column(name = "adult_price")
    private Double adultPrice;

    @Column(name = "child_price")
    private Double childPrice;

    @Column(name="money_type")
    private String moneyType;
}
