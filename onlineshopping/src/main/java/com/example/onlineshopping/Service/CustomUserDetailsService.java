package com.example.onlineshopping.Service;

import com.example.onlineshopping.Entity.User;
import com.example.onlineshopping.Repository.UserRepo;
import com.example.onlineshopping.DTO.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> user = userRepo.findById(username);
        return user.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User Does not Exist"));
    }
}
