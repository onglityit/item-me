package com.darren.mongorest;


import com.darren.mongorest.model.Contact;
import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.Subscription;
import com.darren.mongorest.model.enums.ContactTypeEnum;
import com.darren.mongorest.repo.LandlordRepository;
import com.darren.mongorest.repo.SubscriptionRepository;

import com.darren.mongorest.service.LandlordService;
import com.darren.mongorest.service.LandlordServiceImpl;
import com.darren.mongorest.vo.LandlordHolder;
import com.darren.mongorest.vo.LandlordSubscriptionDataHolder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class LandlordServiceTest {
    static String generatedLandlordUuid;
    static String generatedSubscriptionUuid;
    static Landlord landlordFound, landlordInserted;
    static Subscription subscription;

    @Autowired
    LandlordRepository landlordRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;

    LandlordService landlordService;

    @BeforeAll
    static void setup(){
        generatedSubscriptionUuid = UUID.randomUUID().toString();
        generatedLandlordUuid = UUID.randomUUID().toString();

        landlordInserted = Landlord.builder()
                .id(generatedLandlordUuid)
//                .contact(Contact.builder()
//                        .contactType(ContactTypeEnum.EMAIL.name())
//                        .contactInfo("a@a.a")
//                        .build())
                .username("Test1234!")
                .build();

        subscription = Subscription.builder()
                .id(UUID.randomUUID().toString())
                .companyNickName("best company 01")
                //.landlord(landlordInserted)
                .build();

        //landlordService = new LandlordServiceImpl(landlordRepository);
    }


    @Test
    @Order(2)
    void givenLandlordService_whenAddLandlordSubscription_shouldFindLandlord(){
        //var landlordSubscriptionDataHolder
        //        = LandlordSubscriptionDataHolder.builder()
        //        .landlordHolder(
        //                LandlordHolder.builder()
        //                        .username("Test2345!")
        //                        .email("a@a.a")
        //                        .companyNickName("best company 01")
        //                        .build()
        //        )
        //        .build();

        //landlordService.addLandlordSubscription(landlordSubscriptionDataHolder);


        when(landlordRepository.save(any(Landlord.class))).thenReturn(landlordInserted);
        landlordFound = landlordRepository.save(landlordInserted);
        assertNotNull(landlordFound);
        assertEquals(landlordFound, landlordInserted);
    }

}
