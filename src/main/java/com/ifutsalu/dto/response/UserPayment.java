package com.ifutsalu.dto.response;

import com.ifutsalu.domain.payment.Payment;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserPayment {

    private LocalDateTime paymentTime;

    public static List<UserPayment> fromPayments(List<Payment> payments) {
        return payments.stream()
                .map(UserPayment::fromPayment)
                .collect(Collectors.toList());
    }

    public static UserPayment fromPayment(Payment payment) {
        UserPayment dto = new UserPayment();
        dto.paymentTime = payment.getPaymentTime();
        return dto;
    }
}
