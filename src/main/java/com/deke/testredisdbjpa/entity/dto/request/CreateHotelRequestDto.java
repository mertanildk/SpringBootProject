package com.deke.testredisdbjpa.entity.dto.request;

import com.deke.testredisdbjpa.validation.UniqueHotelName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateHotelRequestDto implements Serializable {

    @NotEmpty
    @UniqueHotelName
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;
}
