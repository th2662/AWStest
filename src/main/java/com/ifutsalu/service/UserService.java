package com.ifutsalu.service;

import com.ifutsalu.domain.user.User;
import com.ifutsalu.domain.user.UserRepository;
import com.ifutsalu.dto.request.UpdateUserRequestDto;
import com.ifutsalu.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findUserInfoById(Long userId) {
        return userRepository.findById(userId)
                .map(UserResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    public UserResponseDto updateUserInfo(Long userId, UpdateUserRequestDto updateUserRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        user.updateUserInfo(updateUserRequestDto);

        User updatedUser = userRepository.save(user);

        return UserResponseDto.of(updatedUser);
    }


}