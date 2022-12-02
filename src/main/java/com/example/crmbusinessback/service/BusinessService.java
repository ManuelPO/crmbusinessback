package com.example.crmbusinessback.service;

import com.example.crmbusinessback.model.entity.Business;
import com.example.crmbusinessback.model.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Business> findByCompany(String company){
        return repo.findByCompany(company);
    }

    public void save(Business business){
        repo.save(business);
    }

    public boolean delete (Integer id){
        Optional<Business> business = repo.findById(id);
        repo.delete(business.orElseThrow());

        Optional<Business> business2 = repo.findById(id);

        if(business2.isEmpty()){
            return true;
        }
        return false;
    }
}
