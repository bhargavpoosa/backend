package com.example.onlineshopping.Service;


import com.example.onlineshopping.Entity.User;
import com.example.onlineshopping.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    public boolean addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User u = userRepo.save(user);
        return u!=null;
    }

    public User authenticate(User user){
        Optional<User> u = userRepo.findById(user.getUsername());
        if(u.isPresent()){
            if(passwordEncoder.matches(user.getPassword(), u.get().getPassword())){
                user.setRoles(u.get().getRoles());
                return user;
            }
        }
        throw new RuntimeException("User Authentication failed");
    }
}
