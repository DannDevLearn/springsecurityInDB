package com.example.usingdb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping("/hello-secured")
    public ResponseEntity<String> helloSecured(){
        return ResponseEntity.ok("Hello world secured!");
    }

    @GetMapping("/hello-admin")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Hello admin!");
    }

}
