package com.darren.mongorest.controller;

import com.darren.mongorest.model.response.SubscriptionResp;
import com.darren.mongorest.service.LandlordService;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
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
    public Callable<ResponseEntity<SubscriptionResp>>
        getAllLandlordSubscriptionByLandlordId(@PathVariable("id") String id){
        return () -> {
            return new ResponseEntity<>(
                    landlordService.getAllLandlordSubscriptionByLandlordId("bdaf67ee-805a-472f-9464-11d4d6094f3e"),
                    HttpStatus.OK);
        };
    }


    @GetMapping("/getList2")
    public Callable<ResponseEntity<SubscriptionResp>> getList2 (){
        return () -> {
            return new ResponseEntity<>(
                    landlordService.getAllLandlordSubscriptionByLandlordId("bdaf67ee-805a-472f-9464-11d4d6094f3e"),
                    HttpStatus.OK);
        };
    }
}
