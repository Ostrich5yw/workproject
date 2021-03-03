package com.example.workproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.workproject.entity.Mapper")

public class WorkprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkprojectApplication.class, args);
    }

}
