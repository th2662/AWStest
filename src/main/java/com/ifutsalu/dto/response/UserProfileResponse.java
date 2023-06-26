package com.ifutsalu.dto.response;

import com.ifutsalu.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProfileResponse {
    private String name;
    private String profileImageUrl;
    private UserAmount amount;

    public static UserProfileResponse fromEntity(User user) {
        return UserProfileResponse.builder()
                .name(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .amount(UserAmount.fromPayment(user.getPayments()))
                .build();
    }
}