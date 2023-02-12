package com.deke.testredisdbjpa.entity.dto.response;


import com.deke.testredisdbjpa.entity.dto.response.base.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDto extends BaseResponseDto {

    private String id;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;
    private Date lastUpdate;
    private Date createdDate;


}
