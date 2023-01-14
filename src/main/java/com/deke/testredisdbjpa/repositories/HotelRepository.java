package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HotelRepository extends BaseRepository<Hotel> {

    List<Hotel> getAllByHotelName(String hotelName);
}
