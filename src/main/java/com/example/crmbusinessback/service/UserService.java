package com.example.crmbusinessback.service;


import com.example.crmbusinessback.model.entity.User;
import com.example.crmbusinessback.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean login(User user){
        Optional<User> foundUser = repo.findByUsername(user.getUsername());

        if(foundUser.isPresent()){
            if(encoder.matches(user.getPassword(), foundUser.get().getPassword())) return true;
        }
        return false;
    }

    public boolean createUser(User user) {
        String encodedPsw = encoder.encode(user.getPassword());
        user.setPassword(encodedPsw);
        Optional<User> foundUser = repo.findByUsername(user.getUsername());
        if(foundUser.isPresent()){
            return false;
        }
        repo.save(user);
        return true;
    }

}
