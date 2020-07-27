package com.freya.springboot.jdbc;

import com.freya.springboot.jdbc.springdatajdbc.SpringDataJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private SpringDataJDBCRepository repository;

    @GetMapping("findAll")
    public List<Dept> findAll() {
        return repository.findALL();
    }
}
