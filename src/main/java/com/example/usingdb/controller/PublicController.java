package com.example.usingdb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/hello")
public class PublicController {

    @GetMapping
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello world public access GET");
    }

    @PostMapping
    public ResponseEntity<String> postHello(){
        return ResponseEntity.ok("Hello world public access POST");
    }

}
