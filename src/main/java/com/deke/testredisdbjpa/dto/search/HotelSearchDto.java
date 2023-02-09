package com.deke.testredisdbjpa.dto.search;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class HotelSearchDto {

    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private int star;


}
/*
@Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_phone")
    private String hotelPhone;

    @Column(name = "hotel_email")
    private String hotelEmail;
    @Column(name = "hotel_stars")
    private int star;
 */
