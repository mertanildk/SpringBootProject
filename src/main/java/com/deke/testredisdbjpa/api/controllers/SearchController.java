package com.deke.testredisdbjpa.api.controllers;


import com.deke.testredisdbjpa.entity.dto.request.SearchRequestDto;
import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/search")
public class SearchController {


    private final SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @PostMapping(path = "/search-all")
    public ResponseEntity<RestResponseEntity<Object>> searchByKeywords(@RequestBody SearchRequestDto searchRequestDto) {
        return ResponseEntity.ok(RestResponseEntity.response(searchService.searchByCityEntryDayEndDateAndGuest(searchRequestDto)));
    }
}
