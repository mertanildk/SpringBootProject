package com.deke.testredisdbjpa.service;


import com.deke.testredisdbjpa.entity.dto.request.SearchRequestDto;
import org.springframework.stereotype.Component;


@Component
public interface SearchService{

    Object searchByCityEntryDayEndDateAndGuest(SearchRequestDto searchRequestDto);
}
