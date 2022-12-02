package com.example.crmbusinessback;

import com.example.crmbusinessback.model.entity.Business;
import com.example.crmbusinessback.model.entity.Contact;
import com.example.crmbusinessback.service.ContactService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactServiceTest{

    @Autowired
    public ContactService contactService;


    @ParameterizedTest
    @MethodSource("generator")
    public void createOpportunityWhenCompanyDoesntExistAndOnlyContactWhenItExist (Contact firstTime, Contact secondTime){
        contactService.createContact(firstTime);
        String firstTimeCompany = firstTime.getCompany();
        Optional<Business> firstBusiness = contactService.getBusinessRepository().findByCompany(firstTimeCompany);
        contactService.createContact(secondTime);
        String secondTimeCompany = secondTime.getCompany();
        Optional<Business> secondBusiness = contactService.getBusinessRepository().findByCompany(secondTimeCompany);
        assertAll(() -> assertTrue(firstBusiness.isPresent()), () -> assertTrue(secondBusiness.isPresent()));
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of(new Contact("Solera","email",new Date(),false), new Contact("Solera","email",new Date(),false)));
    }

}
