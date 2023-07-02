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

    public static UserUpdateResponse of(Optional<User> user) {
        UserUpdateResponse dto = new UserUpdateResponse();
        dto.profileImageUrl = user.get().getProfileImageUrl();
        dto.address = user.get().getAddress();
        dto.level = user.get().getLevel();
        dto.phone = user.get().getPhone();
        return dto;
    }
}
