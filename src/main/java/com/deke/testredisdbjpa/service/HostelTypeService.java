package com.deke.testredisdbjpa.service;

import com.deke.testredisdbjpa.entity.HostelType;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface HostelTypeService extends BaseService<HostelType,String> {

    List<HostelType> updateAll(List<HostelType> hostelTypes);

    List<HostelType> saveAllHostelTypes(List<String> hostelTypeName);

    List<HostelType> getAllByHotel(Hotel hotel);

    List<HostelType> findAllByIdList(List<String> hostelTypeIds);
}
