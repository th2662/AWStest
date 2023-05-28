package com.ifutsalu.controller;

import com.ifutsalu.domain.User;
import com.ifutsalu.dto.user.UserJoinDto;
import com.ifutsalu.dto.user.UserLoginDto;
import com.ifutsalu.dto.user.UserUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        User user = User.builder()
                .email(userLoginDto.getEmail())
                .password(userLoginDto.getPassword())
                .build();

        return ResponseEntity.ok(user);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserJoinDto userJoinDto) {
        User user = User.builder()
                .email(userJoinDto.getEmail())
                .password(userJoinDto.getPassword())
                .name(userJoinDto.getName())
                .phone(userJoinDto.getPhone())
                .gender(userJoinDto.getGender())
                .birth(userJoinDto.getBirth())
                .role(User.Role.ROLE_USER)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> profile(@PathVariable Long id) {
        User user = User.builder()
                .email("sample@gmail.com")
                .password("1234")
                .name("messi")
                .phone("010-1234-5678")
                .gender(User.Gender.MALE)
                .birth(LocalDate.of(1999, 5, 18))
                .role(User.Role.ROLE_USER)
                .build();

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        User user = User.builder()
                .email(userUpdateDto.getEmail())
                .password(userUpdateDto.getPassword())
                .name(userUpdateDto.getName())
                .phone(userUpdateDto.getPhone())
                .gender(userUpdateDto.getGender())
                .birth(userUpdateDto.getBirth())
                .role(User.Role.ROLE_USER)
                .build();

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }
}