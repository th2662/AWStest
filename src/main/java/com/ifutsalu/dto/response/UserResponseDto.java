package com.ifutsalu.dto.response;

import com.ifutsalu.domain.user.Gender;
import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
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

    public static UserResponseDto of(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.email = user.getEmail();
        dto.profileImageUrl = user.getProfileImageUrl();
        dto.password = user.getPassword();
        dto.name = user.getName();
        dto.address = user.getAddress();
        dto.level = user.getLevel();
        dto.phone = user.getPhone();
        dto.gender = user.getGender();
        dto.role = user.getRole();
        dto.birth = user.getBirth();
        return dto;
    }
}
