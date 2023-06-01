package com.ifutsalu.dto.user;

import com.ifutsalu.domain.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateDto {

    private String email;
    private String password;
    private String name;
    private String phone;
    private User.Gender gender;
    private LocalDate birth;
}