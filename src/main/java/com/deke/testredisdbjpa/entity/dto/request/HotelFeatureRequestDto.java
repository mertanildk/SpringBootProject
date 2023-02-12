package com.deke.testredisdbjpa.entity.dto.request;

import com.deke.testredisdbjpa.entity.dto.response.base.BaseResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class HotelFeatureRequestDto extends BaseResponseDto {

    private String hotelId;
    private List<String> hostelTypes;
    private List<String> facilities;

}
