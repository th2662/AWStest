package com.ifutsalu.dto.request;

import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.dto.response.UserResponseDto;
import lombok.Getter;

@Getter
public class UserUpdateRequest {

    private String profileImageUrl;
    private String address;
    private Level level;
    private String phone;


}
