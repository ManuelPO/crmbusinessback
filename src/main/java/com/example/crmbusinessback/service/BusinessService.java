package com.example.crmbusinessback.service;

import com.example.crmbusinessback.model.entity.Business;
import com.example.crmbusinessback.model.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    BusinessRepository repo;

    public List<Business> findAllOpportunity(){
        return repo.findOpportunity();
    }

    public List<Business> findAllCustomer(){
        return repo.findCustomer();
    }
}
