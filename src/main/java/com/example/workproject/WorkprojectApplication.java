package com.example.workproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.example.workproject.entity.Mapper")
@ServletComponentScan       //扫描servlet注解，比如@webfilter@WebListener建filter和listener注入servlet容器中。
public class WorkprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkprojectApplication.class, args);
    }

}



