package com.ifutsalu.controller;

import com.ifutsalu.domain.Payment;
import com.ifutsalu.dto.payment.PaymentChargeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/charge")
    public ResponseEntity<?> chargePoints(@RequestBody PaymentChargeDto paymentChargeDto) {
        Payment payment = new Payment(paymentChargeDto.getAmount(), paymentChargeDto.getPaymentTime());

        return ResponseEntity.ok(payment);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<?> getPaymentHistory(@PathVariable Long userId) {
        List<Payment> paymentHistory = Arrays.asList(
                new Payment(new BigDecimal("20000"), LocalDateTime.now().minusDays(2)),
                new Payment(new BigDecimal("30000"), LocalDateTime.now().minusDays(1))
        );

        return ResponseEntity.ok(paymentHistory);
    }

    @PostMapping("/refund/{paymentId}")
    public ResponseEntity<?> refundPayment(@PathVariable Long paymentId) {

        return ResponseEntity.noContent().build();
    }
}