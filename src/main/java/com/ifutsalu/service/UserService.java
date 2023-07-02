package com.ifutsalu.service;

import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.domain.user.UserRepository;
import com.ifutsalu.dto.request.UserUpdateRequest;
import com.ifutsalu.dto.response.UserResponseDto;
import com.ifutsalu.dto.response.UserUpdateResponse;
import com.ifutsalu.exception.AlreadyManagerRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional
    public UserUpdateResponse updateUserInfo(Long userId, UserUpdateRequest updateUserRequestDto) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new RuntimeException("로그인 유저 정보가 없습니다");
        }

        user.get().updateUserInfo(updateUserRequestDto);

        userRepository.save(user.get());

        return UserUpdateResponse.of(user);
    }


    @Transactional
    public void updateUserRole(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("유저 정보가 없습니다");
        }
        if(user.get().getRole().equals(Role.ROLE_MANAGER)) {
            throw new AlreadyManagerRoleException("이미 매니저 권한을 가지고 있습니다");
        }

        user.get().changeRole(Role.ROLE_MANAGER);

        userRepository.save(user.get());

    }


}