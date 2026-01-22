package com.example.Assessment.Service;


import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.example.Assessment.Model.User;
import com.example.Assessment.Model.UserPrinciple;
import com.example.Assessment.Repo.UserRepository;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository ;

    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public User createUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userRepository.findByUserName(username);

        if(user == null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(user);
        }

    
   
}
