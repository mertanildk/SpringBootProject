package com.deke.testredisdbjpa.entity.dto.search;

import lombok.Data;

@Data
public class CustomerSearchDto {
    private String name;
    private String email;
    private String phone;

}
