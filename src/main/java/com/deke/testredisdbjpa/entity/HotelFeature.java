package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel_features")
public class HotelFeature extends BaseEntity {

    @JoinColumn(name = "hotel_id")
    @ManyToOne
    private Hotel hotel;


    @JoinColumn(name = "facility_id")
    @ManyToOne
    private Facility facility;

    @JoinColumn(name = "hostel_type_id")
    @ManyToOne
    private HostelType hostelType;

}
