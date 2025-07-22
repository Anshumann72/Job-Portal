package com.examly.springapp.exception;

public class UserAlreadyExists extends RuntimeException{

   public  UserAlreadyExists(String msg){
        super(msg);
    }
    
}
