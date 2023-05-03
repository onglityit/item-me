package com.darren.mongorest.service;

import com.darren.mongorest.model.Contact;
import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.Subscription;
import com.darren.mongorest.model.enums.ContactTypeEnum;
import com.darren.mongorest.model.response.SubscriptionResp;
import com.darren.mongorest.repo.LandlordRepository;
import com.darren.mongorest.repo.SubscriptionRepository;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    LandlordRepository landlordRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;


    @Override
    public String addLandlordSubscription(LandlordSubscriptionDataHolder landlordSubscriptionDataHolder) {

        var subscription = Subscription.builder()
                .id(UUID.randomUUID().toString())
                //.landlord(landlord)
                .build();

        var landlord = Landlord.builder()
                .id(UUID.randomUUID().toString())
//                .contact(Contact.builder()
//                        .contactType(ContactTypeEnum.EMAIL.name())
//                        .contactInfo(landlordSubscriptionDataHolder.getLandlordHolder().getEmail())
//                        .build())
                .email(landlordSubscriptionDataHolder.getLandlordHolder().getEmail())
                .username(landlordSubscriptionDataHolder.getLandlordHolder().getUsername())
                .subscriptions(
                        Arrays.asList(Subscription.builder().companyNickName(
                                landlordSubscriptionDataHolder.getLandlordHolder().getCompanyNickName()
                        ).build())
                )
                .build();



        landlordRepository.save(landlord);
        //subscriptionRepository.save(subscription);



        return "success";
    }

    @Override
    public String deleteLandlordById(String id) {
        landlordRepository.deleteById(id);
        return "success";
    }

    public SubscriptionResp getAllLandlordSubscriptionByLandlordId(String id){
        return SubscriptionResp.builder().subscriptions(
                landlordRepository.findLandlordById(id).getSubscriptions()
        ).build();

    }

}
