package com.darren.mongorest.controller;

import com.darren.mongorest.service.LandlordService;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api")
public class LandlordController {
    @Autowired
    LandlordService landlordService;

    @PostMapping("/addLandlordSubscription")
    public Callable<ResponseEntity<String>> addLandlordSubscription(@RequestBody LandlordSubscriptionDataHolder landlordSubscriptionDataHolder){
        return () ->{
          return landlordService.addLandlordSubscription(landlordSubscriptionDataHolder);
        };
    }

    @DeleteMapping("/deleteLandlord/{id}")
    public Callable<ResponseEntity<String>> deleteLandlordById(@PathVariable("id") String id,
                                                                  @RequestParam(required = false, defaultValue = "1") String isSoftDelete){
        return () -> {
            return landlordService.deleteLandlordById(id);
        };
    }
}
