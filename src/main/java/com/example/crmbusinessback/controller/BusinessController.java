package com.example.crmbusinessback.controller;

import com.example.crmbusinessback.model.entity.Business;
import com.example.crmbusinessback.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class BusinessController {

    @Autowired
    BusinessService service;

    @GetMapping("/opportunity")
    public List<Business> listAllOpportunity(){
        return service.findAllOpportunity();
    }

    @GetMapping("/customer")
    public List<Business> listAllCustomer(){
        return service.findAllCustomer();
    }

    @PostMapping("/opportunity/edit")
    public void editOpportunity(Business business){
        Optional<Business> saveBusiness = service.findByCompany(business.getCompany());
        saveBusiness.orElseThrow().setCompany(business.getCompany());
        saveBusiness.orElseThrow().setDate(business.getDate());
        saveBusiness.orElseThrow().setDescription(business.getDescription());
        saveBusiness.orElseThrow().setCustomer(!business.isCustomer());

        service.save(saveBusiness.orElseThrow());
    }

    @PostMapping("/customer/edit")
    public void editCustomer(Business business){
        Optional<Business> saveBusiness = service.findByCompany(business.getCompany());
        saveBusiness.orElseThrow().setCompany(business.getCompany());
        saveBusiness.orElseThrow().setDate(business.getDate());
        saveBusiness.orElseThrow().setDescription(business.getDescription());
        saveBusiness.orElseThrow().setCustomer(business.isCustomer());

        service.save(saveBusiness.orElseThrow());
    }

    @PostMapping("/customer/delete/{id}")
    public boolean deleteCustomer (@PathVariable Integer id){
        return service.delete(id);
    }
}
