package com.ifutsalu.dto.user;

import com.ifutsalu.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class UserUpdateDto {

    private String email;
    private String password;
    private String name;
    private String phone;
    private User.Gender gender;
    private LocalDate birth;
}