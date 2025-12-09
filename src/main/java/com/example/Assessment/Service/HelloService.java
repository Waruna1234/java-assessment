package com.example.Assessment.Service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String generateMessage(String name) {

        if(name == null || name.trim().isEmpty()){
            return null;
        }

        char first = Character.toLowerCase(name.charAt(0));

        if (first >= 'a' && first <= 'm') {
            return "Hello " + capitalize(name);
        }

        return null;
        
    }

    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    
}
