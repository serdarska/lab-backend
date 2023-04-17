package com.example.lab1.service;

import com.example.lab1.model.Author;
import com.example.lab1.model.Country;
import com.example.lab1.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(AuthorDto authorDto);

    public Author create(String name, String surname, Country country);

    List<Author> listAll();
}
