package com.example.crmbusinessback.model.repository;

import com.example.crmbusinessback.model.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {

    @Query(value = "SELECT * FROM  Business b WHERE b.company LIKE ?1", nativeQuery = true)
    public Optional<Business> findByCompany(String company);
}
