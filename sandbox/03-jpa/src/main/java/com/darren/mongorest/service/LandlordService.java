package com.darren.mongorest.service;

import org.springframework.http.ResponseEntity;

public interface LandlordService {
    ResponseEntity<String> addLandlordSubscription();
}
