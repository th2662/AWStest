package com.ifutsalu.dto.response;

import com.ifutsalu.domain.user.Gender;
import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserResponseDto {

    private String email;
    private String profileImageUrl;
    private String password;
    private String name;
    private String address;
    private Level level;
    private String phone;
    private Gender gender;
    private Role role;
    private LocalDate birth;
}
