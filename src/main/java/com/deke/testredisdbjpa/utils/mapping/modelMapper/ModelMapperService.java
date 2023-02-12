package com.deke.testredisdbjpa.utils.mapping.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forClass();

    ModelMapper forDto();
}
