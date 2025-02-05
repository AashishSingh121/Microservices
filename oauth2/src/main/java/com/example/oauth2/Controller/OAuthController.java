package com.example.oauth2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/")
    public ResponseEntity fetch(){
        return ResponseEntity.accepted().body("HELLO");
    }

    @GetMapping("/secure")
    public ResponseEntity fetchSecure(){
        return ResponseEntity.accepted().body("secured");
    }
}
