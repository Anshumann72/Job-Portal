# deefdaafcac329136918cdfbcccefone
https://sonarcloud.io/summary/overall?id=iamneo-production_deefdaafcac329136918cdfbcccefone

package com.examly.springapp.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
String pwd = PasswordEncoder.encode(user.getPassword());
user.setPassword(pwd);
return userRepo.save(user);
}
@Override
public Optional<User> loginUser(User user) {
return userRepo.findByUsername(user.getUsername());
}
}
