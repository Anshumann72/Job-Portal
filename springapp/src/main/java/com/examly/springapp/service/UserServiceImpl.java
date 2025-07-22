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
private PasswordEncoder PasswordEncoder;

    @Override
    public User registerUser(User user) {
        if(user.getPassword()==null || user.getPassword().isEmpty()){
            throw new IllegalArgumentException("Username cant be null");
        }

        if(user.getPassword() ==null|| user.getPassword().isEmpty()){
            throw new IllegalArgumentException("Password cant be null");
        }


        String pwd = PasswordEncoder.encode(user.getPassword());
        user.setPassword(pwd);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> loginUser(User user) {
        return userRepo.findByUsername(user.getUsername());
    }

}
