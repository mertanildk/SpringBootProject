package com.deke.testredisdbjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TestRedisDbJpaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TestRedisDbJpaApplication.class, args);
    }

}
