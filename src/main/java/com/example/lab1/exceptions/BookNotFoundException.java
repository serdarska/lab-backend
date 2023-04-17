package com.example.lab1.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(){
        super("BookNotFoundException");
    }

}
