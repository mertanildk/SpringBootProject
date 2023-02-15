package com.deke.testredisdbjpa.configs.cache.httpHeader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class HttpHeaderConfig {
    @Bean
    public HttpHeaders httpHeaders(){return new HttpHeaders();}
}
