package com.ifutsalu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role {
        ROLE_USER, ROLE_MANAGER, ROLE_ADMIN
    }

    private String email;
    private String password;
    private String name;
    private String phone;
    private Gender gender;
    private Role role;
    private LocalDate birth;
}