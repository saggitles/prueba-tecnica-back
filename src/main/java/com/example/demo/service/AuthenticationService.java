package com.example.demo.service;

import com.example.demo.models.JwtAuthenticationResponse;
import com.example.demo.models.UserRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(UserRequest request);

    JwtAuthenticationResponse signin(UserRequest request);
}
