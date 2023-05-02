package com.darren.mongorest.controller;

import com.darren.mongorest.model.Subscription;
import com.darren.mongorest.model.response.SubscriptionResp;
import com.darren.mongorest.service.LandlordService;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import com.darren.mongorest.vo.request.LandlordSubscriptionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class LandlordController {
    @Autowired
    LandlordService landlordService;

    @PostMapping("/addLandlordSubscription")
    public Callable<ResponseEntity<String>> addLandlordSubscription(@RequestBody LandlordSubscriptionDataHolder landlordSubscriptionDataHolder){
        return () ->{
          return new ResponseEntity<>(landlordService.addLandlordSubscription(landlordSubscriptionDataHolder), HttpStatus.OK);
        };
    }

    @DeleteMapping("/deleteLandlord/{id}")
    public Callable<ResponseEntity<String>> deleteLandlordById(@PathVariable("id") String id,
                                                                  @RequestParam(required = false, defaultValue = "1") String isSoftDelete){
        return () -> {
            return new ResponseEntity<>(landlordService.deleteLandlordById(id), HttpStatus.OK);
        };
    }

    @GetMapping("/getAllLandlordSubscriptionByLandlordId/{id}")
    public Callable<ResponseEntity<SubscriptionResp>> getAllLandlordSubscriptionByLandlordId(@PathVariable("id") String id,
                                                                                             @RequestParam LandlordSubscriptionReq landlordSubscriptionReq){
        return () -> {
            return new ResponseEntity<>(
                    landlordService.getAllLandlordSubscriptionByLandlordId(id), HttpStatus.OK);
        };
    }
}
