package com.ifutsalu.dto.request;

import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.Role;
import lombok.Getter;

@Getter
public class UpdateUserRequestDto {

    private String profileImageUrl;
    private String password;
    private String address;
    private Level level;
    private String phone;
    private Role role;
}
