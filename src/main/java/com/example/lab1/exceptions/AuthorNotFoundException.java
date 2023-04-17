package com.example.lab1.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(){
        super("Author Not Found Exception");
    }

}
