package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.service.HotelService;
import com.deke.testredisdbjpa.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service("searchService")
public class SearchServiceImp implements SearchService {

    @Autowired
    private HotelService hotelService;

    @Override
    public Object search(String keyword) {
        Iterable<Hotel> hotels = hotelService.findAll();
        List<Hotel> hotelContainsKeyword = new ArrayList<>();
        hotels.forEach(hotel -> {
            if (hotel.getHotelName().contains(keyword)) {
                hotelContainsKeyword.add(hotel);
            }
        });

        List<Hotel> hotelList = StreamSupport.stream(hotels.spliterator(), false).collect(Collectors.toList());
        hotelList.remove(1);



        return hotelContainsKeyword;

    }
}
