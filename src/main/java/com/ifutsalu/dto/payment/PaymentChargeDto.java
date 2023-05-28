package com.ifutsalu.dto.payment;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentChargeDto {

    private BigDecimal amount;
    private LocalDateTime paymentTime;
}