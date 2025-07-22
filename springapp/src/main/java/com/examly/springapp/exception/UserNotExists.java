package com.examly.springapp.exception;

public class UserNotExists extends RuntimeException {

   public UserNotExists(String msg){
        super(msg);
    }
    
}
