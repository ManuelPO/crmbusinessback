package com.example.crmbusinessback.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="business")
@Data
public class Business {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String company;

    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private boolean customer;

    public Business() {
    }

    public Business(Integer id, String company, String description, Date date, boolean customer) {
        this.id = id;
        this.company = company;
        this.description = description;
        this.date = date;
        this.customer = customer;
    }

    public Business(String company, Date date, boolean customer) {
        this.company = company;
        this.date = date;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }
}
