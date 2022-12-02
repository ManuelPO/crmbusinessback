package com.example.crmbusinessback.service;

import com.example.crmbusinessback.model.entity.Business;
import com.example.crmbusinessback.model.entity.Contact;
import com.example.crmbusinessback.model.repository.BusinessRepository;
import com.example.crmbusinessback.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    BusinessRepository businessRepository;

    public void createContact(Contact contact){
        String company = contact.getCompany();
        Optional<Business> businessOptional = businessRepository.findByCompany(company);
        String type1 = contact.getContactWay();

        if(businessOptional.isPresent() && !businessOptional.get().isCustomer() && type1.equals("contract")){
            Business business = new Business(contact.getCompany(), contact.getDate(), true);
            businessRepository.save(business);
            contactRepository.save(contact);

        } else if(businessOptional.isPresent()) {
            contactRepository.save(contact);

        }else if(businessOptional.isEmpty()){
            Business business = new Business(contact.getCompany(), contact.getDate(), false);
            businessRepository.save(business);
            contactRepository.save(contact);
        }
    }

    public BusinessRepository getBusinessRepository(){
        return this.businessRepository;
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public List<Contact> findByCompany (String company){
        return contactRepository.findByCompany(company);
    }

    public List<Contact> findPlanned(){
        return contactRepository.findPlanned();
    }

}
