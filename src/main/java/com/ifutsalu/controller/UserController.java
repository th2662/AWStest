package com.ifutsalu.controller;

import com.ifutsalu.domain.User;
import com.ifutsalu.dto.user.UserJoinDto;
import com.ifutsalu.dto.user.UserLoginDto;
import com.ifutsalu.dto.user.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Tag(name = "UserController", description = "유저 컨트롤러")
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 로그인
     */
    @Operation(summary = "회원 로그인", description = "로그인 됩니다", tags = {"UserController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    headers = {
                            @Header(name = "추가 정보", description = "헤더 설명")
                    }),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        User user = User.builder()
                .email(userLoginDto.getEmail())
                .password(userLoginDto.getPassword())
                .build();

        return ResponseEntity.ok(user);
    }


    /**
     * 회원가입
     */

    @Operation(summary = "회원 가입", description = "회원 가입을 수행합니다", tags = {"UserController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    })
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


    /**
     * 회원 프로필 조회
     */
    @Operation(summary = "회원 프로필 조회", description = "회원 프로필을 조회합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
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


    /**
     * 회원정보 수정
     */
    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
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


    /**
     * 회원삭제
     */
    @Operation(summary = "회원 삭제", description = "회원 정보를 삭제합니다", tags = {"UserController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    headers = {
                            @Header(name = "추가 정보", description = "헤더 설명")
                    }),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        return ResponseEntity.ok().body("삭제 완료");
    }
}