package com.examly.springapp.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;

@Service
public interface UserService {

    User register(User user);

    Optional<User> login(User user);

}
