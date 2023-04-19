package com.darren.mongorest.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import com.darren.mongorest.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    HelloService helloService;

    @Operation(summary = "hello")
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>(helloService.helloOnce(), HttpStatus.OK);
    }
}
