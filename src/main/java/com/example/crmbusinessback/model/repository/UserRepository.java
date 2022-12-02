package com.example.crmbusinessback.model.repository;

import com.example.crmbusinessback.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value ="SELECT * FROM User u WHERE u.username LIKE ?1", nativeQuery = true)
    public Optional<User> findByUsername(String username);


}
