package com.examly.springapp.controller;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.config.JwtUtils;
import com.examly.springapp.config.MyUserDetailsService;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            System.out.println(userDetails.getUsername()+" "+userDetails.getPassword());
            String token = jwtUtils.generateToken(userDetails);
            System.out.println(token);
            Optional<User> userData = userService.loginUser(user);
            if (userData.isPresent()) {
                User u = userData.get();
                return ResponseEntity.ok(Map.of(
                        "token", token,
                        "id", u.getUserId(),
                        "role", u.getRole()));
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}