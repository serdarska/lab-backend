package com.example.lab1.exceptions;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(){
        super("Country Not Found Exception!");
    }

}
