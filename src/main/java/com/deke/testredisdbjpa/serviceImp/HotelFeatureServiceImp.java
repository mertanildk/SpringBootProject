package com.deke.testredisdbjpa.serviceImp;


import com.deke.testredisdbjpa.dto.request.CreateHotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.request.HotelFeatureRequestDto;
import com.deke.testredisdbjpa.dto.response.HotelFeatureResponseDto;
import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.entity.HotelFeature;
import com.deke.testredisdbjpa.repositories.HotelFeatureRepository;
import com.deke.testredisdbjpa.service.FacilityService;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.service.HotelFeatureService;

import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("hotelFeatureService")
public class HotelFeatureServiceImp extends BaseServiceImp<HotelFeature, HotelFeature, HotelFeatureRepository, HotelFeature> implements HotelFeatureService {

    @Autowired
    private HotelFeatureRepository hotelFeatureRepository;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private HostelTypeService hostelTypeService;

    @Autowired
    private HotelService hotelService;


    @Override
    public List<HotelFeature> addHotelFeature(CreateHotelFeatureRequestDto createHotelFeatureRequestDto) {
        int facilitySize = createHotelFeatureRequestDto.getFacilityIds().size();
        int hostelTypeSize = createHotelFeatureRequestDto.getHostelTypeIds().size();
        List<HotelFeature> hotelFeatures = new ArrayList<>();
        while (Math.max(facilitySize, hostelTypeSize) >= 0) {
            HotelFeature hotelFeature = new HotelFeature();
            hotelFeature.setHotelOid(createHotelFeatureRequestDto.getHotelId());
            hotelFeature.setFacilityOid(--facilitySize >= 0 ? createHotelFeatureRequestDto.getFacilityIds().get(facilitySize) : null);
            hotelFeature.setHostelTypeOid(--hostelTypeSize >= 0 ? createHotelFeatureRequestDto.getHostelTypeIds().get(hostelTypeSize) : null);
            if (hotelFeature.getFacilityOid() != null && hotelFeature.getHostelTypeOid() != null) {
                hotelFeatureRepository.save(hotelFeature);
                hotelFeatures.add(hotelFeature);
            }

        }
        return hotelFeatures;
    }

    @Override
    @Cacheable(value = "hotelFeature", key = "#hotelId")
    public List<HotelFeature> findAllByHotelId(String hotelId) {
        return hotelFeatureRepository.findAllByHotel(hotelId);
    }

    @Override
    @CacheEvict(value = "hotelFeature", key = "#hotelId")
    public List<HotelFeature> updateHotelFeature(String hotelId, HotelFeatureRequestDto hotelFeatureRequestDto) {
        List<HotelFeature> hotelFeatures = findAllByHotelId(hotelId);
        int index = 0;
        for (HotelFeature hotelFeature : hotelFeatures) {
            if (!hotelFeatureRequestDto.getFacilities().contains(hotelFeature.getFacilityOid())) {
                HotelFeature hotelFeature1 = new HotelFeature();
                hotelFeature1.setHotelOid(hotelId);
                hotelFeature1.setFacilityOid(hotelFeatureRequestDto.getFacilities().get(index));
                hotelFeature1.setHostelTypeOid(hotelFeatureRequestDto.getHostelTypes().get(index++));
                hotelFeatures.add(hotelFeature1);
            }
        }
        getDao().saveAll(hotelFeatures);
        return hotelFeatures;


    }

    @Override
    public HotelFeatureResponseDto showHotelFeatures(String hotelId){
        List<HotelFeature> hotelFeatures = findAllByHotelId(hotelId);
        HotelFeatureResponseDto hotelFeatureResponseDto = new HotelFeatureResponseDto();
        hotelFeatureResponseDto.setHotel(hotelService.findOne(hotelId).isPresent()?hotelService.findOne(hotelId).get():null);
        hotelFeatureResponseDto.setFacilities(facilityService.findAllByIdList(hotelFeatures.stream().map(HotelFeature::getFacilityOid).collect(Collectors.toList())));
        hotelFeatureResponseDto.setHostelTypes(hostelTypeService.findAllByIdList(hotelFeatures.stream().map(HotelFeature::getHostelTypeOid).collect(Collectors.toList())));
        return  hotelFeatureResponseDto;
    }
}
