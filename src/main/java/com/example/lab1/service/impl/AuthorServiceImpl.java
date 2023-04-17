package com.example.lab1.service.impl;

import com.example.lab1.exceptions.CountryNotFoundException;
import com.example.lab1.model.Author;
import com.example.lab1.model.Country;
import com.example.lab1.model.dto.AuthorDto;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException());
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        return Optional.of(this.authorRepository.save(author));

    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name,surname,country);
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }
}
