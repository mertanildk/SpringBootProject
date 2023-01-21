package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.HotelRoom;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("hotelRoomRepository")
public interface HotelRoomRepository extends BaseRepository<HotelRoom> {

}
