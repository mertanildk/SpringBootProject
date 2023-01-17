package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "hotels_rooms")
public class HotelRooms extends BaseEntity {

    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "room_count")
    private int roomCount;
}
