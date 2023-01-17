package com.deke.testredisdbjpa.service;


import org.springframework.stereotype.Component;

@Component
public interface SearchService{

    Object search(String keyword);
}
