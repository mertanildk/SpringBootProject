package com.deke.testredisdbjpa.controllers;


import com.deke.testredisdbjpa.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    @GetMapping(path = "/search")
    public ResponseEntity<RestResponseEntity<Object>> seach(String keyword) {
        return ResponseEntity.ok(RestResponseEntity.response(searchService.search(keyword)));
    }
}
