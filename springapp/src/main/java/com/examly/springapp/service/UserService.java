package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;

@Service
public interface UserService {

    User register(User user);

    User login(User user);

}
