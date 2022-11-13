package com.codesigne.marjanepromo.model;


import com.codesigne.marjanepromo.DAO.AdminCenterDao;
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

    private Boolean dispo;
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

    public static void main(String[] args) {
        Center c = new Center();
        c.setNom("Marjane");
        c.setVille("Rabat");
        c.setDispo(true);
        AdminCenterDao ad = new AdminCenterDao();

    }
}
