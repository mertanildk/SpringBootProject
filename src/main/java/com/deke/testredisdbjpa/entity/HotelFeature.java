package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel_features")
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
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
