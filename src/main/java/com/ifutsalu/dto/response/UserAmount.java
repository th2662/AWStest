package com.ifutsalu.dto.response;

import com.ifutsalu.domain.payment.Payment;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class UserAmount {

    private BigDecimal amount;

    public static UserAmount fromPayment(List<Payment> payments) {
       UserAmount dto = new UserAmount();
       if (!payments.isEmpty()) {
           dto.amount = payments.get(0).getAmount();
       }
       return dto;
    }
}
