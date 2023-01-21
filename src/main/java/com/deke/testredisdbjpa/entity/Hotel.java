package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "hotels")
@Entity
@Builder @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends BaseEntity {

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_phone")
    private String hotelPhone;

    @Column(name = "hotel_email")
    private String hotelEmail;

    @Column(name = "hotel_stars")
    private int star;
}
