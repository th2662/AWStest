package com.ifutsalu.dto.response;

import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class UserProfileResponse {
    private String name;
    private String profileImageUrl;
    private BigDecimal amount;

    public static UserProfileResponse fromEntity(User user) {

        return UserProfileResponse.builder()
                .name(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .amount(user.getPayments().get(0).getAmount())
                .build();
    }
}