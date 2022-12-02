package com.example.crmbusinessback.controller;

import com.example.crmbusinessback.model.entity.Contact;
import com.example.crmbusinessback.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    @Autowired
    ContactService service;

    @GetMapping("/list")
    public List<Contact> listAll(){
        return service.findAll();
    }
}
