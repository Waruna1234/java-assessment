package com.example.Assessment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assessment.Model.User;
import com.example.Assessment.Service.UserAuthService;
import com.example.Assessment.Service.UserService;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthService  userAuthService;

    @PostMapping("/creat")
    public User createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user.getUserName());
        return userAuthService.verify(user);
    }

    
}
