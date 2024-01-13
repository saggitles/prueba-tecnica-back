package com.example.demo.controllers;


import com.example.demo.models.JwtAuthenticationResponse;
import com.example.demo.models.UserRequest;
import com.example.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class ApiController {


    private final AuthenticationService authenticationService;
    @PostMapping(value = "/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody UserRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
