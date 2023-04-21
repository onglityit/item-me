package com.darren.mongorest.service;

import com.darren.mongorest.model.Contact;
import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.Subscription;
import com.darren.mongorest.model.enums.ContactTypeEnum;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class LandlordServiceImpl implements LandlordService {


    @Override
    public ResponseEntity<String> addLandlordSubscription(LandlordSubscriptionDataHolder landlordSubscriptionDataHolder) {

        var landlord = Landlord.builder()
                .id(UUID.randomUUID().toString())
                .contact(Contact.builder()
                        .contactType(ContactTypeEnum.EMAIL.name())
                        .build())
                .username(landlordSubscriptionDataHolder.getLandlordHolder().getUsername())

                .build();

        var subscription = Subscription.builder()

                .id(UUID.randomUUID().toString())
                .landlord(landlord)
                .build();



        return null;
    }
}
