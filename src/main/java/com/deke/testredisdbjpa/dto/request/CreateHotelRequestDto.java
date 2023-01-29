package com.deke.testredisdbjpa.dto.request;

import com.deke.testredisdbjpa.validation.UniqueHotelName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateHotelRequestDto implements Serializable {

    @NotEmpty
    @NotBlank
    @UniqueHotelName
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;
    /*

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_phone")
    private String hotelPhone;

    @Column(name = "hotel_email")
    private String hotelEmail;

    @Column(name = "hotel_stars")
    private int star;
     */
}
