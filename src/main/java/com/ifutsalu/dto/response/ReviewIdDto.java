package com.ifutsalu.dto.response;


import com.ifutsalu.domain.user.User;
import lombok.Getter;

@Getter
public class ReviewIdDto {
    private Long id;
    private String email;
    private String name;

    public static ReviewIdDto fromUser(User user) {
        ReviewIdDto dto = new ReviewIdDto();
        dto.id = user.getId();
        dto.email = user.getEmail();
        dto.name = user.getName();
        return dto;
    }

}

