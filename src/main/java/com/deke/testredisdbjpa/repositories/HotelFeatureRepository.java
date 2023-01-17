package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.HotelFeature;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HotelFeatureRepository extends BaseRepository<HotelFeature> {

    @Query("select f from HotelFeature f where f.hotel.oid = :hotelId")
    List<HotelFeature> findAllByHotel(String hotelId);
}
