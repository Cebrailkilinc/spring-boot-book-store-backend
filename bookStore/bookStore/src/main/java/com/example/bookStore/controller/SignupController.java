package com.example.bookStore.controller;

import com.example.bookStore.dto.request.SignupRequest;
import com.example.bookStore.dto.response.GetSignupResponse;
import com.example.bookStore.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SignupController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest){
        GetSignupResponse createdUser = authService.createCustomer(signupRequest);
        if (createdUser == null)
        {
            return new ResponseEntity<>("User is not created.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
