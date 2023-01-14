package com.deke.testredisdbjpa.dto.response;


import com.deke.testredisdbjpa.dto.response.base.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
