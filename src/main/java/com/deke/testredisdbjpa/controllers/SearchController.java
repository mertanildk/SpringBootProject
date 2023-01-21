package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.dto.request.SearchRequestDto;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/search")
public class SearchController {


    private final SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping(path = "/search-all")
    public ResponseEntity<RestResponseEntity<Object>> seachByKeywords(@RequestBody SearchRequestDto searchRequestDto) {
        return ResponseEntity.ok(RestResponseEntity.response(searchService.searchByCityEntryDayEndDateAndGuest(searchRequestDto)));
    }
}
