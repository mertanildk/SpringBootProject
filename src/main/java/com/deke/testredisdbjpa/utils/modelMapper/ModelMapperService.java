package com.deke.testredisdbjpa.utils.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forClass();

    ModelMapper forDto();
}
