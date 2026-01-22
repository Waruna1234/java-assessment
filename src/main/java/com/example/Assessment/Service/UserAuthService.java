package com.example.Assessment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.Assessment.Model.User;

@Service
public class UserAuthService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;


    public String verify(User user) {
        System.out.println(user.getUserName());
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUserName());

        return "fail";

    }


    
}
