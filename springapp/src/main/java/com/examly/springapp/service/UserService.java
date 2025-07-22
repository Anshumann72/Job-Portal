
package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
@Service
public interface UserService {
public User registerUser(User user);
public User loginUser(User user);
}

