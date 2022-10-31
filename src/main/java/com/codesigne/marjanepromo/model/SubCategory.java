package com.codesigne.marjanepromo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(mappedBy = "subCategory")
    private Promotion promotion;

    @OneToOne(mappedBy = "subCategory")
    private MarketManager marketManager;

    //ToString function
    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", promotion=" + promotion +
                ", marketManager=" + marketManager +
                '}';
    }
}
