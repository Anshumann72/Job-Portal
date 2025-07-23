package com.examly.springapp.exception;

public class InvalidDateException extends RuntimeException {

    public InvalidDateException(String msg){
        super(msg);
    }
    
}
