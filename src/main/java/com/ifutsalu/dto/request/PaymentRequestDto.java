package com.ifutsalu.dto.request;

import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.domain.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class PaymentRequestDto {

    private BigDecimal amount;
    private LocalDateTime paymentTime;
    private User user;

    public Payment toEntity() {
        return Payment.builder()
                .amount(amount)
                .paymentTime(paymentTime)
                .user(user)
                .build();
    }
}
