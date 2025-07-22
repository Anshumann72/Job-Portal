package com.examly.springapp.exception;

public class UserAlreadyExists extends Exception{

   public  UserAlreadyExists(String msg){
        super(msg);
    }
    
}
