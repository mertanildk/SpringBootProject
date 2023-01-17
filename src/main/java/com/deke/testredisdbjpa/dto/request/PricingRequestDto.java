package com.deke.testredisdbjpa.dto.request;

import com.deke.testredisdbjpa.dto.response.base.BaseResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingRequestDto extends BaseResponseDto {

    private String hotelOid;
    private String roomOid;
    private String periodOid;
    private String hostelTypeOid;
    private Double adultPrice;
    private Double childPrice;
    private String moneyType;
}
