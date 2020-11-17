package com.freya.springboot.swagger3;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanchengpin
 */
@RestController
@Api(tags = "swagger3")
@SpringBootApplication
public class SpringbootSwagger3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger3Application.class, args);
    }

    @GetMapping("swagger3")
    @ApiOperation(value = "swagger3", notes = "swagger3")
    public String swagger3Test() {
        return "Hello Swagger3";
    }

}
