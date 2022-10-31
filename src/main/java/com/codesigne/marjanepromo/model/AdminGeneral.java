package com.codesigne.marjanepromo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AdminGeneral implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @OneToMany(mappedBy = "adminGeneral",fetch = FetchType.LAZY)
    private List<AdminCenter> adminCenter;

    //getters and setters

    //toString function
    @Override
    public String toString() {
        return "AdminGeneral{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", adminCenter=" + adminCenter +
                '}';
    }


}
