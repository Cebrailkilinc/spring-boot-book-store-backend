package com.example.bookStore.utilities.auth;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {

    private Map<String, String> users = new HashMap<>();

    @PostConstruct
    public void init(){
        users.put("cebrail@gmail.com","123456");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

