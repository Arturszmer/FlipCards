package com.example.flipcardsapp.exceptionHandler;

import org.springframework.http.HttpStatus;

public class MyExceptions extends RuntimeException {

    public MyExceptions(HttpStatus httpStatus, String message){
        super(httpStatus + message);
    }

}
