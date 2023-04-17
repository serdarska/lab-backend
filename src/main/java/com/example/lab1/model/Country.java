package com.example.lab1.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Country {

    public Country() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name")
    private String name;

    @Column(name="country_continent")
    private String continent;

    public Country(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
