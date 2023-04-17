package com.example.lab1.model.dto;

import com.example.lab1.model.Country;
import lombok.Data;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Long countryId;
}
