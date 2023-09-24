package com.example.onlineshopping.Controller;

import com.example.onlineshopping.Entity.User;
import com.example.onlineshopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public HttpStatus addUser(@RequestBody User user){
        if(userService.addUser(user))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @PostMapping("/authenticate")
    public User authenticate(@RequestBody User user){
        return userService.authenticate(user);
    }

}
