package com.ifutsalu.dto.request;

import com.ifutsalu.domain.user.Level;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private String profileImageUrl;
    private String address;
    private Level level;
    private String phone;


}
