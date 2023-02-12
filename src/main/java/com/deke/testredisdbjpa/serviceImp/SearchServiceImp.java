package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.dto.request.SearchRequestDto;
import com.deke.testredisdbjpa.service.PricingService;
import com.deke.testredisdbjpa.service.SearchService;
import org.springframework.stereotype.Service;


import java.util.stream.StreamSupport;


@Service("searchService")
public class SearchServiceImp implements SearchService {
    private final PricingService pricingService;

    public SearchServiceImp(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public Object searchByCityEntryDayEndDateAndGuest(SearchRequestDto searchRequestDto) {
        return StreamSupport.stream(pricingService.findAll().spliterator(), false)
                .filter(pricing ->
                        pricing.getHotel().getHotelAddress().contains(searchRequestDto.getCity()) &&
                                pricing.getPeriod().getStartDate().before(searchRequestDto.getEntryDay()) &&
                                searchRequestDto.getEntryDay().before(searchRequestDto.getEndDate()) &&
                                pricing.getPeriod().getEndDate().after(searchRequestDto.getEndDate()) &&
                                pricing.getRoom().getBedCount() >= searchRequestDto.getBedCount()
                ).toList();
    }
}