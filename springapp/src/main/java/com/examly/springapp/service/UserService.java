package com.examly.springapp.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;

@Service
public interface UserService {

    User registerUser(User user);

    Optional<User> loginUser(User user);

}
