package com.deke.testredisdbjpa.dto.request;

import com.deke.testredisdbjpa.validation.UniqueNameValid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestDto {
    @NotNull
    @UniqueNameValid
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String password;
}
