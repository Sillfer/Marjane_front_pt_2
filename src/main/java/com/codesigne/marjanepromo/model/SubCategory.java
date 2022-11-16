package com.codesigne.marjanepromo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "subCategory",fetch = FetchType.LAZY)
    private List <Promotion> promotion;

    @OneToOne(mappedBy = "subCategory")
    private MarketManager marketManager;

    private Boolean dispo;

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
