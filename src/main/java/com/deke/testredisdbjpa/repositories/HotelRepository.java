package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HotelRepository extends BaseRepository<Hotel> {

    @Query("select h from Hotel h where h.hotelName = :hotelName")
    List<Hotel> getAllByHotelName(String hotelName);
}
