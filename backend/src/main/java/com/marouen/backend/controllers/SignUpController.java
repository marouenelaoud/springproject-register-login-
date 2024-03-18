package com.marouen.backend.controllers;

import com.marouen.backend.dto.SignupRequest;
import com.marouen.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    private final AuthService authService;
    @Autowired
    public SignUpController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping
    public ResponseEntity<String> SignupUser(@RequestBody SignupRequest signupRequest) {

        boolean isUserCreated = authService.createUser(signupRequest);
        if(isUserCreated){
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Already Exists");
        }

    }
}
