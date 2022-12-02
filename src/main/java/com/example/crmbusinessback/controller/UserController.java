package com.example.crmbusinessback.controller;

import com.example.crmbusinessback.model.entity.User;
import com.example.crmbusinessback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        return service.login(user);
    }
}
