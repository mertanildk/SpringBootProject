package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.HostelType;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.HostelTypeRepository;
import com.deke.testredisdbjpa.service.HostelTypeService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("hostelTypeService")
public class HostelTypeServiceImp extends BaseServiceImp<HostelType, HostelType, HostelTypeRepository,HostelType> implements HostelTypeService {

    @Autowired
    private HostelTypeRepository hostelTypeRepository;


    @Override
    public List<HostelType> updateAll(List<HostelType> hostelTypes) {
        hostelTypes.forEach(hostelType->getDao().save(hostelType));
        return hostelTypes;
    }

    @Override
    public List<HostelType> saveAllHostelTypes(List<String> hostelTypeNames) {
        List<HostelType> hostelTypes = new ArrayList<>();
        hostelTypeNames.forEach(hostelType->{
            HostelType hostelType1 = new HostelType();
            hostelType1.setHostelTypeName(hostelType);
            hostelTypes.add(hostelType1);
        });
        getDao().saveAll(hostelTypes);
        return hostelTypes;
    }

    @Override
    public List<HostelType> getAllByHotel(Hotel hotel) {
        return null;
    }

    @Override
    public List<HostelType> findAllByIdList(List<String> hostelTypeIds) {
        return hostelTypeRepository.findAllById(hostelTypeIds);
    }
}
