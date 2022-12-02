package com.example.crmbusinessback.controller;

import com.example.crmbusinessback.model.entity.Business;
import com.example.crmbusinessback.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
