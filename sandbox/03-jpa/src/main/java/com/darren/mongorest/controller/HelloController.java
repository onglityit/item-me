package com.darren.mongorest.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import com.darren.mongorest.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class HelloController {

    @Autowired
    HelloService helloService;

    @Operation(summary = "hello")
    @GetMapping("/hello")
    public Callable<ResponseEntity<String>> hello(){
        return () -> {
            return helloService.helloOnce();
        };
    }
}
