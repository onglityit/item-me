package com.darren.mongorest;


import com.darren.mongorest.model.Contact;
import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.enums.ContactTypeEnum;
import com.darren.mongorest.repo.LandlordRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class LandlordServiceTest {
    static String generatedUuid;

    @Autowired
    LandlordRepository landlordRepository;

    @BeforeAll
    static void setup(){
        generatedUuid = UUID.randomUUID().toString();
    }


    @Test
    @Order(1)
    void givenLandlordRepository_whenAddNewLandlord_shouldFindLandlord(){
        Landlord landlordFound,
                landlordInserted = Landlord.builder()
                .id(generatedUuid)
                .contact(Contact.builder()
                        .contactType(ContactTypeEnum.EMAIL.name())
                        .contactInfo("a@a.a")
                        .build())
                .username("Test1234!")
                .build();
        landlordRepository.save(landlordInserted);
        landlordFound = landlordRepository.findLandlordById(generatedUuid);
    }
}
