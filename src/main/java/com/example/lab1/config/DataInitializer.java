package com.example.lab1.config;


import com.example.lab1.model.enumerations.Category;
import com.example.lab1.service.AuthorService;
import com.example.lab1.service.BookService;
import com.example.lab1.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }


    private Category randomizePosition(int i) {
        if (i % 3 == 0) return Category.NOVEL;
        else if (i % 3 == 1) return Category.THRILER;
        return Category.HISTORY;
    }

    @PostConstruct
    public void initData() {
        for (int i = 1; i < 6; i++) {
            this.authorService.create("AuthorName: " + i, "AuthorSurname: " + i, this.countryService.create("CountryName: " + i, "CountryContinent:" + i));
        }


        for (int i = 1; i < 11; i++) {
            this.bookService.create("Book: " + i, this.randomizePosition(i), this.authorService.listAll().get((i-1)%5).getId(), i + 2);
        }
    }
}

