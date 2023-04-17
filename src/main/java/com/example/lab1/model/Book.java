package com.example.lab1.model;

import com.example.lab1.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book+name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "book_category")
    private Category category;

    @ManyToOne
    private Author author;

    @Column(name = "available_copies")
    private Integer availableCopies;


    @Column(name = "book_availability")
    private boolean availability;

    public Book(Long id, String name, Category category, Author author, Integer availableCopies, boolean availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
        this.availability = availability;
    }


    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
        availability = true;
    }
}
