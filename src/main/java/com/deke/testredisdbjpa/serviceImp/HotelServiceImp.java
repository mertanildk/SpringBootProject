package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.HotelRepository;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.service.RoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;


@Service("hotelService")
public class HotelServiceImp extends BaseServiceImp<Hotel, Hotel, HotelRepository, Hotel> implements HotelService {
    @Autowired
    private RoomService roomService;

    @Autowired
    private HostelTypeService hostelTypeService;

    @CacheEvict(value = "hotel", key = "#id")
    public void deleteHotel(String id) {
        getDao().deleteById(id);
    }

    @Override
    public Hotel addHotel(CreateHotelRequestDto createHotelRequestDto) {
        Hotel hotel = Hotel.builder()
                .hotelAddress(createHotelRequestDto.getHotelAddress())
                .hotelName(createHotelRequestDto.getHotelName())
                .hotelPhone(createHotelRequestDto.getHotelPhone())
                .hotelEmail(createHotelRequestDto.getHotelEmail())
                .star(createHotelRequestDto.getStar())
                .build();
        getDao().save(hotel);
        return hotel;
    }
}