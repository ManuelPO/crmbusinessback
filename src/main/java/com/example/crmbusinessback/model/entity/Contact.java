package com.example.crmbusinessback.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="contact")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String company;

    @Column(nullable = false)
    private String type;

    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private boolean planned;

    public Contact(Integer id, String company, String type, String description, Date date, boolean planned) {
        this.id = id;
        this.company = company;
        this.type = type;
        this.description = description;
        this.date = date;
        this.planned = planned;
    }

    public Contact(String company, String type, Date date, boolean planned) {
        this.company = company;
        this.type = type;
        this.date = date;
        this.planned = planned;
    }

    public Contact() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isPlanned() {
        return planned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

}
