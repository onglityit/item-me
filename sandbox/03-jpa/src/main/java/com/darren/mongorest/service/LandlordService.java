package com.darren.mongorest.service;

import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.Subscription;
import com.darren.mongorest.model.response.SubscriptionResp;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LandlordService {

    //refactor - SAGA - responseEntitty for controllers only
    String addLandlordSubscription(LandlordSubscriptionDataHolder landlordSubscriptionDataHolder);
    String deleteLandlordById(String id);
    SubscriptionResp getAllLandlordSubscriptionByLandlordId(String id);

}
