package com.freya.dynamic.datasource.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private TestService service;


    @GetMapping(path = {"test01"})
    public List<Map<String, Object>> test01() {
        return service.test01();
    }

    @GetMapping("test02")
    public List<Map<String, Object>> test02() {
        return service.test02();
    }

    @GetMapping("test03")
    public List<Map<String, Object>> test03() {
        return service.test03();
    }
}
