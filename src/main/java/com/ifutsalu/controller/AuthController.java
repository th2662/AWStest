package com.ifutsalu.controller;


import com.ifutsalu.dto.request.TokenRequestDto;
import com.ifutsalu.dto.request.UserRequestDto;
import com.ifutsalu.dto.response.TokenResponseDto;
import com.ifutsalu.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AuthController", description = "회원 컨트롤러")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     * 회원가입
     * @param userRequestDto 회원 가입 요청 정보
     * @return 회원 가입 결과 메시지
     */
    @Operation(summary = "회원 가입", description = "회원가입", tags = {"AuthController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    headers = {
                            @Header(name = "추가 정보", description = "헤더 설명")
                    }),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    })
    @PostMapping("/join")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto userRequestDto) {
        authService.join(userRequestDto);
        return ResponseEntity.ok("회원가입에 성공했습니다");
    }

    /**
     * 로그인
     *
     * @param userRequestDto 로그인 요청 정보
     * @return 로그인 결과를 담은 토큰 응답 DTO
     */
    @Operation(summary = "로그인", description = "로그인", tags = {"AuthController"})
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(authService.login(userRequestDto));
    }

    /**
     * 토큰 재발급
     *
     * @param tokenRequestDto 토큰 재발급 요청 정보
     * @return 재발급된 토큰 응답 DTO
     */
    @Operation(summary = "토큰 재발급", description = "토큰 재발급", tags = {"AuthController"})
    @PostMapping("/reissue")
    public ResponseEntity<TokenResponseDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}

