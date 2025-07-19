package com.examly.springapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
public class AuthController {


    @Autowired
    UserService userService;

    @PostMapping("api/user/register")
    public ResponseEntity<?> register(User user){
      User u1=userService.register(user);
      if(u1!=null) return new ResponseEntity<>(u1,HttpStatus.valueOf(201));
      return new ResponseEntity<>(HttpStatus.valueOf(400));
    }


    @PostMapping("api/user/login")
    public ResponseEntity<?> login(User user){
      Optional<User> u1=userService.login(user);
      if(u1.isPresent()) return new ResponseEntity<>(u1,HttpStatus.valueOf(201));
      return new ResponseEntity<>(HttpStatus.valueOf(400));
    }

}
