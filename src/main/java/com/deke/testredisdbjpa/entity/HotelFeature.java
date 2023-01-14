package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "hotel_features")
public class HotelFeature extends BaseEntity {

    @Column(name = "hotel_id")
    private String hotel;

    @Column(name = "facility_id")
    private String facility;

    @Column(name = "hostel_type_id")
    private String hostelType;

}
