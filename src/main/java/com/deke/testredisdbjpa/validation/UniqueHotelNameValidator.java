package com.deke.testredisdbjpa.validation;

import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.repositories.HotelRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UniqueHotelNameValidator implements ConstraintValidator<UniqueHotelName,String> {

    private final HotelRepository hotelRepository;

    public UniqueHotelNameValidator(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public boolean isValid(String hotelName, ConstraintValidatorContext constraintValidatorContext) {
        return hotelRepository.findAll().stream().noneMatch(hotel -> hotel.getHotelName().equals(hotelName));
    }
}
