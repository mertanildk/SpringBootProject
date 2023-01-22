package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel_rooms")
@Entity @Getter @Setter
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
public class HotelRoom extends BaseEntity {


    @JoinColumn(name = "hotel_id")
    @ManyToOne
    private Hotel hotel;

    @JoinColumn(name = "room_id")
    @ManyToOne
    private Room room;

    @Column(name = "room_count")
    private int roomCount;

    @Column(name="active_room_count")
    private int activeRoomCount;

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
        this.activeRoomCount=roomCount;
    }
}
