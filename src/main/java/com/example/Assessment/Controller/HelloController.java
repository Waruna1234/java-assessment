package com.example.Assessment.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assessment.Service.HelloService;

import jakarta.servlet.http.HttpServletRequest;

import com.example.Assessment.Model.Student;

@RestController
@RequestMapping("/hello-world") 
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    List<Student> studets = new ArrayList<>(
        Arrays.asList(
            new Student("Waruna",23),
            new Student("Selaka", 27)
        )
    );

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }


    @GetMapping
    public ResponseEntity<?> hello(@RequestParam(required = false) String name){

        if(name == null || name.trim().isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input"));
        }

        String response = helloService.generateMessage(name);

        if(response == null){
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input"));
        }

        return ResponseEntity.ok(Map.of("message", response));

    }

    @PostMapping
    public List<Student> saveData(@RequestBody Student studen){
        studets.add(studen);
        // System.out.println(studets);
        return studets;    
        }
    
}
