package com.example.lab1.service.impl;

import com.example.lab1.exceptions.AuthorNotFoundException;
import com.example.lab1.exceptions.BookNotFoundException;
import com.example.lab1.model.Author;
import com.example.lab1.model.Book;
import com.example.lab1.model.dto.BookDto;
import com.example.lab1.model.enumerations.Category;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.repository.BookRepository;
import com.example.lab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getBookAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException());
        Category category = Category.valueOf(bookDto.getCategory());
        Book book = new Book(bookDto.getName(), category,author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException());
        Author author = this.authorRepository.findById(bookDto.getBookAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException());
        book.setName(bookDto.getName());
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        this.bookRepository.delete(book);

    }

    @Override
    public Optional<Book> changeAvailability(Long id) {
        Book exchangedBook = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException());
        Integer availableCopies = exchangedBook.getAvailableCopies();

        if(availableCopies > 0){
            exchangedBook.setAvailableCopies(--availableCopies);

            if(availableCopies == 0){
                exchangedBook.setAvailability(false);
            }
        }
        return Optional.of(this.bookRepository.save(exchangedBook));
    }

    @Override
    public Book create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author1 = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException());
        Book book = new Book(name, category, author1, availableCopies);
        return this.bookRepository.save(book);
    }
}
