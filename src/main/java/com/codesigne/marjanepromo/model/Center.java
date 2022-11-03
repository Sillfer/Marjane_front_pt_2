package com.codesigne.marjanepromo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Center implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String ville;

    @OneToOne
    private AdminCenter adminCenter;
    //getters and setters


    //toString function
    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", adminCenter=" + adminCenter +
                '}';
    }
}
