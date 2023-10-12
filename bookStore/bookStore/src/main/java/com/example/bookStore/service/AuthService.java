package com.example.bookStore.service;

import com.example.bookStore.dto.request.SignupRequest;
import com.example.bookStore.dto.response.GetSignupResponse;
import com.example.bookStore.model.Customer;
import com.example.bookStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public GetSignupResponse createCustomer(SignupRequest signupRequest) {
        Customer customer = new Customer();
        customer.setUsername(signupRequest.getUsername());
        customer.setEmail(signupRequest.getEmail());
        customer.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        Customer createdUser = customerRepository.save(customer);
        GetSignupResponse getSignupResponse = new GetSignupResponse();
        getSignupResponse.setId(createdUser.getId());
        getSignupResponse.setEmail(createdUser.getEmail());
        getSignupResponse.setUsername(signupRequest.getUsername());
        getSignupResponse.setPassword(signupRequest.getPassword());

        return getSignupResponse;
    }
}
