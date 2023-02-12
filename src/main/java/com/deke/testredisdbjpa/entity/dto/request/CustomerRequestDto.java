package com.deke.testredisdbjpa.entity.dto.request;

import com.deke.testredisdbjpa.validation.UniqueCustomerName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestDto {
    @NotNull
    @UniqueCustomerName
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String password;
}
