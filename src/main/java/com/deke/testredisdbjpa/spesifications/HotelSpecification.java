package com.deke.testredisdbjpa.spesifications;

import com.deke.testredisdbjpa.dto.search.HotelSearchDto;
import com.deke.testredisdbjpa.entity.Hotel;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HotelSpecification {
    public Specification<Hotel> search(HotelSearchDto hotelSearchDto) {
        //Bence çok güzel bi kod oldu
        ArrayList<String> fields = Arrays.stream(Hotel.class.getDeclaredFields()).map(Field::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (ObjectUtils.isNotEmpty(hotelSearchDto.getHotelName()))
                predicates.add(cb.like(root.get(fields.get(0)), hotelSearchDto.getHotelName()));

            if (ObjectUtils.isNotEmpty(hotelSearchDto.getHotelAddress()))
                predicates.add(cb.like(root.get(fields.get(1)), "%" + hotelSearchDto.getHotelAddress()));


            if (ObjectUtils.isNotEmpty(hotelSearchDto.getHotelPhone()))
                predicates.add(cb.like(root.get(fields.get(2)), "%" + hotelSearchDto.getHotelAddress()));


            if (ObjectUtils.isNotEmpty(hotelSearchDto.getHotelEmail()))
                predicates.add(cb.like(root.get(fields.get(3)), "%" + hotelSearchDto.getHotelEmail()));


            /* Integer aramanın yolunu bulmamız gerekiyor.
            if (ObjectUtils.isNotEmpty(hotelSearchDto.getStar()))
                predicates.add(cb.like(root.get(fields.get(4)), "%" + hotelSearchDto.getStar()));

             */

            return cb.and(predicates.toArray(new Predicate[0]));
        };


    }
}

