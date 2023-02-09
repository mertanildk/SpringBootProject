package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CreateHotelRequestDto;
import com.deke.testredisdbjpa.dto.search.HotelSearchDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.HotelRepository;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.service.RoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import com.deke.testredisdbjpa.spesifications.HotelSpecification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("hotelService")
@RequiredArgsConstructor
public class HotelServiceImp extends BaseServiceImp<Hotel, Hotel, HotelRepository, Hotel> implements HotelService {


    private final ModelMapper modelMapper;
    private final HotelRepository hotelRepository;


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

    @Override
    public List<Hotel> searchAllHotels(HotelSearchDto hotelSearchDto) {
        HotelSpecification hotelSpecification = new HotelSpecification();
        List<Hotel> hotelList = hotelRepository.findAll(Specification.where(hotelSpecification.search(hotelSearchDto)));
        return hotelList;
    }
    //List<User> userList = userRepository.findAll(Specification.where(userSpecification.search(userSearchDto)));
}