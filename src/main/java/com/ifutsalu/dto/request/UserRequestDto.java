package com.ifutsalu.dto.request;

import com.ifutsalu.domain.user.Gender;
import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Getter
@Builder
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

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .profileImageUrl(profileImageUrl)
                .password(passwordEncoder.encode(password))
                .name(name)
                .address(address)
                .level(level)
                .phone(phone)
                .gender(gender)
                .role(Role.ROLE_USER)
                .birth(birth)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
