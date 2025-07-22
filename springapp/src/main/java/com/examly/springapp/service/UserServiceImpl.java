
package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.PasswordIncorrect;
import com.examly.springapp.exception.UserAlreadyExists;
import com.examly.springapp.exception.UserNotExists;
import com.examly.springapp.model.Job;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if(userRepo.findByUsername(user.getUsername())!=null){
           throw new UserAlreadyExists("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepo.save(user);
    }

    public User loginUser(User user) {
        User eUser=userRepo.findByUsername(user.getUsername());
        if(eUser==null){
            throw new UserNotExists("User doesnot exist!");
        }
        if(!(passwordEncoder.matches(user.getPassword(), eUser.getPassword()))){
            throw new PasswordIncorrect("Password is incorrect.. please enter valid password");
        }
      return eUser;
    }
    
}

