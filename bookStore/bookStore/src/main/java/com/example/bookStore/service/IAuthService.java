package com.example.bookStore.service;

import com.example.bookStore.dto.request.SignupRequest;
import com.example.bookStore.dto.response.GetSignupResponse;

public interface IAuthService {
    GetSignupResponse createCustomer(SignupRequest signupRequest);
}
