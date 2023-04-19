package com.darren.mongorest.service;

import com.darren.mongorest.model.Tutorial;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class HelloService {
    static List<String> hellos = new ArrayList<>();

    public String helloOnce(){
        return "hello";
    }
}
