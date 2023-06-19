package com.ifutsalu.dto.response;

import com.ifutsalu.domain.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class PaymentResponseDto {

    private BigDecimal amount;
    private LocalDateTime paymentTime;
    private User user;
}
