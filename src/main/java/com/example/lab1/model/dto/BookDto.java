package com.example.lab1.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private String name;

    private String category;

    private Long bookAuthorId;

    private Integer availableCopies;
}
