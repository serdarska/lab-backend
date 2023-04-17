package com.example.lab1.service;

import com.example.lab1.model.Author;
import com.example.lab1.model.Book;
import com.example.lab1.model.dto.BookDto;
import com.example.lab1.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> changeAvailability(Long id);

    public Book create(String name, Category category, Long author, Integer availableCopies);
}
