package com.examly.springapp.exception;

public class UserAlreadyApplied extends RuntimeException {

    public UserAlreadyApplied(String msg){
        super(msg);
    }
    
}
