package com.codesigne.marjanepromo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AdminCenter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @ManyToOne
    private AdminGeneral adminGeneral;

    @OneToMany(mappedBy = "adminCenter",fetch = FetchType.LAZY)
    private List<Promotion> promotion;

    @OneToMany(mappedBy = "adminCenter",fetch = FetchType.LAZY)
    private List<MarketManager> marketManager;

    @OneToOne
    private Center center;



    //getters and setters

    //toString
    @Override
    public String toString() {
        return "AdminCenter{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", adminGeneral=" + adminGeneral +
                ", promotion=" + promotion +
                ", marketManager=" + marketManager +
                ", center=" + center +
                '}';
    }
}
