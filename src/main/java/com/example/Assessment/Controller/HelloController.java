package com.example.Assessment.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assessment.Service.HelloService;

@RestController
@RequestMapping("/hello-world")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
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
    
}
