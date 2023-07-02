package com.ifutsalu.service;

import com.ifutsalu.dto.request.UserRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;


class AuthServiceTest {

    AuthService authService;





    @Test
    void 회원가입() {

        //given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .email("th2662@naver.com")
                .password("123456")
                .build();

        //when
        authService.join(userRequestDto);

        //then
        assertThat(userRequestDto.getEmail()).isEqualTo("th2662@naver.com");
    }

    @Test
    void 회원가입_중복() {

        //given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .email("th2662@naver.com")
                .password("123456")
                .build();


        //when
        authService.join(userRequestDto);

        //then
        assertThat(userRequestDto.getEmail()).isEqualTo("th2662@naver.com");
    }
}