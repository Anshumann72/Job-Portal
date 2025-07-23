package com.examly.springapp.exception;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(String msg){
        super(msg);
    }
    
}
