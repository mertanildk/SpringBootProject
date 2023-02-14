package com.deke.testredisdbjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TestRedisDbJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRedisDbJpaApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public HttpHeaders httpHeaders(){return new HttpHeaders();}




}
