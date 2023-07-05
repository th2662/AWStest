package com.ifutsalu.dto.response;

import com.ifutsalu.domain.user.Level;
import com.ifutsalu.domain.user.User;
import lombok.Getter;

import java.util.Optional;


@Getter
public class UserUpdateResponse {

    private String profileImageUrl;
    private String address;
    private Level level;
    private String phone;

    public static UserUpdateResponse of(User user) {
        UserUpdateResponse dto = new UserUpdateResponse();
        dto.profileImageUrl = user.getProfileImageUrl();
        dto.address = user.getAddress();
        dto.level = user.getLevel();
        dto.phone = user.getPhone();
        return dto;
    }
}
