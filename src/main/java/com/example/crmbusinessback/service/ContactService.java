package com.example.crmbusinessback.service;

import com.example.crmbusinessback.model.entity.Contact;
import com.example.crmbusinessback.model.repository.BusinessRepository;
import com.example.crmbusinessback.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    BusinessRepository businessRepository;

    public boolean createContact(Contact contact){
        return false;
    }

    public BusinessRepository getBusinessRepository(){
        return this.businessRepository;
    }
}
