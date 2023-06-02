package com.ifutsalu.dto.payment;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
public class PaymentChargeDto {

    private BigDecimal amount;
    private LocalDateTime paymentTime;
}