package com.darren.mongorest.controller;

import com.darren.mongorest.model.response.SubscriptionResp;
import com.darren.mongorest.service.LandlordService;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class LandlordController {
    @Autowired
    LandlordService landlordService;

    @PostMapping("/addLandlordSubscription")
    public Callable<ResponseEntity<String>> addLandlordSubscription(@RequestBody LandlordSubscriptionDataHolder landlordSubscriptionDataHolder){
        return () ->{
          return ResponseEntity.ok(landlordService.addLandlordSubscription(landlordSubscriptionDataHolder));
        };
    }

    @DeleteMapping("/deleteLandlord/{id}")
    public Callable<ResponseEntity<String>> deleteLandlordById(@PathVariable("id") String id,
                                                                  @RequestParam(required = false, defaultValue = "1") String isSoftDelete){
        return () -> {
            return ResponseEntity.ok(landlordService.deleteLandlordById(id));
        };
    }


    @GetMapping("/getAllLandlordSubscriptionsByLandlordId/{id}")
    public Callable<ResponseEntity<SubscriptionResp>>
    getAllLandlordSubscriptionsByLandlordId(@PathVariable("id") String id){
        return () -> {
            return ResponseEntity.ok(
                    landlordService.getAllLandlordSubscriptionByLandlordId("bdaf67ee-805a-472f-9464-11d4d6094f3e"));
        };
    }
}
