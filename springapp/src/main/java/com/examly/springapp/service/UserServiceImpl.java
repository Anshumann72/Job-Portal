package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
private UserRepo userRepo;
@Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        String pwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(pwd);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> login(User user) {
        return userRepo.findByUsername(user.getUsername());
    }

}
