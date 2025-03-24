package com.example.springapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    private Long id;
    private String username;
    private String jwtToken;
    private String role;
}
