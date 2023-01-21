package com.deke.testredisdbjpa.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class SearchRequestDto {

    private String city;
    private Date entryDay;
    private Date endDate;
    private int bedCount;
    
}
