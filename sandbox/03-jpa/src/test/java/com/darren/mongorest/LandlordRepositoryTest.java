package com.darren.mongorest;


import com.darren.mongorest.model.Contact;
import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.Subscription;
import com.darren.mongorest.model.enums.ContactTypeEnum;
import com.darren.mongorest.repo.LandlordRepository;
import com.darren.mongorest.repo.SubscriptionRepository;
import com.darren.mongorest.service.LandlordService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class LandlordRepositoryTest {
    static String generatedLandlordUuid;
    static String generatedSubscriptionUuid;
    static Landlord landlordFound, landlordInserted;
    static Subscription subscription;

    @Autowired
    LandlordRepository landlordRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    LandlordService landlordService;

    @BeforeAll
    static void setup(){
        generatedSubscriptionUuid = UUID.randomUUID().toString();
        generatedLandlordUuid = UUID.randomUUID().toString();

        landlordInserted = Landlord.builder()
                .id(generatedLandlordUuid)
                .contact(Contact.builder()
                        .contactType(ContactTypeEnum.EMAIL.name())
                        .contactInfo("a@a.a")
                        .build())
                .username("Test1234!")
                .build();

        subscription = Subscription.builder()
                .id(UUID.randomUUID().toString())
                .companyNickName("best company 01")
                //.landlord(landlordInserted)
                .build();
    }

    @Test
    @Order(1)
    void givenLandlordRepository_whenAddNewLandlord_shouldFindLandlord(){


        landlordRepository.save(landlordInserted);
        subscriptionRepository.save(subscription);

        landlordFound = landlordRepository.findLandlordById(generatedLandlordUuid);
        assertNotNull(landlordFound);
        assertEquals(landlordFound, landlordInserted);
        landlordRepository.deleteById(generatedLandlordUuid);
        subscriptionRepository.deleteById(generatedSubscriptionUuid);
    }

}
