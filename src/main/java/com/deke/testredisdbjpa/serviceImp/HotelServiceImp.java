package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.HotelRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelResponseDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.entity.HostelType;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.HotelRepository;
import com.deke.testredisdbjpa.service.FacilityService;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("hotelService")
public class HotelServiceImp extends BaseServiceImp<Hotel, Hotel, HotelRepository, Hotel> implements HotelService {


    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private HostelTypeService hostelTypeService;


    @Override
    public HotelResponseDto getByHotelId(String id) {
        Optional<Hotel> optionalHotel = getDao().findById(id);
        return null;
    }

    @Override
    public String deleteCache(String id) {
        return "deleted cache name  = hotel, key -> " + id;

    }

    @CacheEvict(value = "hotel", key = "#id")
    public void deleteHotel(String id) {
        getDao().deleteById(id);
    }


    @Override
    public HotelResponseDto updateHotel(String id, HotelRequestDto hotelRequestDto) {
        return null;
    }

    @Override
    public Hotel addHotel(List<String> specifications,List<String> hostelTypeNames) {
        Hotel hotel = new Hotel();
        List<Facility> facilities = facilityService.getBySpesiciations(specifications);
        List<HostelType> hostelTypes = getHostelTypeByName(hostelTypeNames);
        //hotel.setFacility(facilities);
        //hotel.setHostelType(hostelTypes);
        hotelRepository.save(hotel);
        return hotel;
    }
    private List<HostelType> getHostelTypeByName(List<String> hostelTypeNames) {

        List<HostelType> hostelTypeList = new ArrayList<>();
        hostelTypeService.getList().forEach(hostelType -> {
            hostelTypeNames.forEach(hostelTypeName -> {
                if (hostelType.getHostelTypeName().equals(hostelTypeName)) {
                    hostelTypeList.add(hostelType);
                }
            });
        });

        return hostelTypeList;
    }


    private List<String> getSpecifications(List<Facility> facilities){
        return facilities.stream().map(Facility::getSpecifications).collect(Collectors.toList());
    }

    private Hotel getHotelById(String id) {
        Optional<Hotel> optionalHotel = getDao().findById(id);
        return optionalHotel.get();
    }


    private Hotel transferFromRequestDto(String id, HotelRequestDto hotelRequestDto, Hotel hotel) {
        hotel.setHotelName(hotelRequestDto.getHotelName());
        hotel.setHotelAddress(hotelRequestDto.getHotelAddress());
        hotel.setHotelPhone(hotelRequestDto.getHotelPhone());
        hotel.setHotelEmail(hotelRequestDto.getHotelEmail());
        hotel.setStar(hotelRequestDto.getStar());
        return hotel;

    }
    private Hotel setNotNullFields(HotelRequestDto hotelRequestDto,Hotel hotel){
        hotel.setHotelEmail(hotelRequestDto.getHotelEmail() != null ? hotelRequestDto.getHotelEmail() : hotel.getHotelEmail());
        hotel.setHotelAddress(hotelRequestDto.getHotelAddress() != null ? hotelRequestDto.getHotelAddress() : hotel.getHotelAddress());
        hotel.setHotelName(hotelRequestDto.getHotelName() != null ? hotelRequestDto.getHotelName() : hotel.getHotelName());
        hotel.setStar(hotelRequestDto.getStar() >= 0 ? hotelRequestDto.getStar() : hotel.getStar());
        //hotel.setFacilities(hotelRequestDto.getFacilities() != null ? getFacilities(hotelRequestDto.getFacilities())  : hotel.getFacilities());
        //hotel.setHostelType(hotelRequestDto.getHostelTypes() != null ? getHostelTypes(hotelRequestDto.getHostelTypes()) : hotel.getHostelType());
        hotel.setHotelPhone(hotelRequestDto.getHotelPhone() != null ? hotelRequestDto.getHotelPhone() : hotel.getHotelPhone());
        return hotel;
    }

    private List<Facility> getFacilities(List<String> facilities) {
        List<Facility> facilityList = new ArrayList<>();
        facilities.forEach(facility -> {
            Facility facility1 = new Facility();
            facility1.setSpecifications(facility);
            facilityList.add(facility1);
        });
        return facilityList;
    }
    private List<HostelType> getHostelTypes(List<String> hostelTypes){
        List<HostelType> hostelTypeList = new ArrayList<>();
        hostelTypes.forEach(hostelType ->{
            HostelType hostelType1 = new HostelType();
            hostelType1.setHostelTypeName(hostelType);
            hostelTypeList.add(hostelType1);
        });
        return hostelTypeList;
    }
}
/*
updatedHotel.setHotelPhone(hotelRequestDto.getHotelPhone() != null ? hotelRequestDto.getHotelPhone() : updatedHotel.getHotelPhone());
        updatedHotel.setHotelEmail(hotelRequestDto.getHotelEmail() != null ? hotelRequestDto.getHotelEmail() : updatedHotel.getHotelEmail());
        updatedHotel.setHotelAddress(hotelRequestDto.getHotelAddress() != null ? hotelRequestDto.getHotelAddress() : updatedHotel.getHotelAddress());
        updatedHotel.setHotelName(hotelRequestDto.getHotelName() != null ? hotelRequestDto.getHotelName() : updatedHotel.getHotelName());
        updatedHotel.setStar(hotelRequestDto.getStar() >= 0 ? hotelRequestDto.getStar() : updatedHotel.getStar());
        updatedHotel.setFacilities(hotelRequestDto.getFacilities() != null ? getFacilities(hotelRequestDto.getFacilities())  : updatedHotel.getFacilities());
        updatedHotel.setHostelType(hotelRequestDto.getHostelTypes() != null ? getHostelTypes(hotelRequestDto.getHostelTypes()) : updatedHotel.getHostelType());
        updatedHotel.setHotelPhone(hotelRequestDto.getHotelPhone() != null ? hotelRequestDto.getHotelPhone() : updatedHotel.getHotelPhone());
 */