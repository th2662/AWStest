package com.ifutsalu.dto.response;

import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserPaymentResponseDto {

    private String userName;
    private List<UserPayment> payments;

    public static UserPaymentResponseDto fromEntity(List<Payment> payments, User user) {
        return UserPaymentResponseDto.builder()
                .userName(user.getName())
                .payments(UserPayment.fromPayments(payments))
                .build();
    }
}
