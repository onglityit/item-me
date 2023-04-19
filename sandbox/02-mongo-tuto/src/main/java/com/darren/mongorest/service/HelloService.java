package com.darren.mongorest.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    static List<String> hellos = new ArrayList<>();

    public ResponseEntity<String> helloOnce(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
