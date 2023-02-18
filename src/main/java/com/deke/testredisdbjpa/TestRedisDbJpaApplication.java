package com.deke.testredisdbjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableMongoRepositories
public class TestRedisDbJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRedisDbJpaApplication.class, args);
    }
}
