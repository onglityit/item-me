package com.darren.mongorest.service;

import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.http.ResponseEntity;

public interface LandlordService {

    ResponseEntity<String> addLandlordSubscription(LandlordSubscriptionDataHolder landlordSubscriptionDataHolder);
    ResponseEntity<String> deleteLandlordById(String id);
}
