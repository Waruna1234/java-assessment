package com.example.Assessment.Controller;

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
    public ResponseEntity<?> hello(@RequestParam String name){
        

        String response = helloService.generateMessage(name);

        if(response == null){
            return ResponseEntity.badRequest().body(
                    "Invalid Input"
            );
        }

        return ResponseEntity.ok(response);


    }
    
}
