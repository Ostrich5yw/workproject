package com.example.workproject;

import com.example.workproject.Service.UnitService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestService {
    @Resource
    UnitService unitService;
    @Test
    public void test(){
        unitService.getAllUnit(1, 10);
    }
}
