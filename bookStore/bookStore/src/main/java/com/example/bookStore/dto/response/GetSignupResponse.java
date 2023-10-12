package com.example.bookStore.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSignupResponse {
    private int id;
    private String username;
    private String email;
    private String password;
    private String address;
}
