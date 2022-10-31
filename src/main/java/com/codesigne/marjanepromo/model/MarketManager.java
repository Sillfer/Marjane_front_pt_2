package com.codesigne.marjanepromo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class MarketManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @ManyToOne
    private AdminCenter adminCenter;


    @OneToOne
    private SubCategory subCategory;

    //getters and setters generated automotaiclly via lombouk annotation

    //ToString function
    @Override
    public String toString() {
        return "MarketManager{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", adminCenter=" + adminCenter +
                ", subCategory=" + subCategory +
                '}';
    }
}
