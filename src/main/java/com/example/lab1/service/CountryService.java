package com.example.lab1.service;

import com.example.lab1.model.Country;
import com.example.lab1.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> save(CountryDto countryDto);

    public Country create(String name, String continent);
}
