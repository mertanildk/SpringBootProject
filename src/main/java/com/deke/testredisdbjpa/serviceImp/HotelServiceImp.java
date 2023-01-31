package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.HotelRepository;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.service.RoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;


@Service("hotelService")
public class HotelServiceImp extends BaseServiceImp<Hotel, Hotel, HotelRepository, Hotel> implements HotelService {

    private final RoomService roomService;
    private final HostelTypeService hostelTypeService;
    private final ModelMapper modelMapper;
    private final HotelRepository hotelRepository;

    public HotelServiceImp(RoomService roomService, HostelTypeService hostelTypeService, ModelMapper modelMapper,
                           HotelRepository hotelRepository) {
        this.roomService = roomService;
        this.hostelTypeService = hostelTypeService;
        this.modelMapper = modelMapper;
        this.hotelRepository = hotelRepository;
    }

    @CacheEvict(value = "hotel", key = "#id")
    @Override
    public boolean deleteHotel(String id) {
        getDao().deleteById(id);
        return findOne(id).isEmpty();
    }

    @Override
    public Hotel addHotel(CreateHotelRequestDto createHotelRequestDto) {
        Hotel hotel = modelMapper.map(createHotelRequestDto, Hotel.class);
        return hotelRepository.save(hotel);
    }

    @Override
    public CreateHotelRequestDto getHotelDTO(String id) {
        return modelMapper.map(findOne(id).orElse(null), CreateHotelRequestDto.class);
    }
}