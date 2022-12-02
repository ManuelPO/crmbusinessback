package com.example.crmbusinessback.model.repository;

import com.example.crmbusinessback.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query(value = "SELECT * FROM Contact c WHERE c.company LIKE ?1", nativeQuery = true)
    public List<Contact> findByCompany(String company);

}
