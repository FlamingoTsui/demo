package com.flamingo.junit5test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.flamingo.junit5test.dao")
public class Junit5TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Junit5TestApplication.class, args);
    }

}
