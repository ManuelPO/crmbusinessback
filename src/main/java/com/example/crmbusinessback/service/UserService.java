package com.example.crmbusinessback.service;


import com.example.crmbusinessback.model.entity.User;
import com.example.crmbusinessback.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;


    public boolean login(User user){

        return false;
    }

}
