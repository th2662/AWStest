package com.ifutsalu.dto.request;

import com.ifutsalu.domain.user.Gender;
import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserRequestDto {

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

    public User toEntity() {
        return User.builder()
                .email(email)
                .profileImageUrl(profileImageUrl)
                .password(password)
                .name(name)
                .address(address)
                .level(level)
                .phone(phone)
                .gender(gender)
                .role(role)
                .birth(birth)
                .build();
    }
}
