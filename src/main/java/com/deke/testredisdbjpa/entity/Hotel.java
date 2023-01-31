package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Table(name = "hotels")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
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
