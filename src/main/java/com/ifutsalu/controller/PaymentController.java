package com.ifutsalu.controller;

import com.ifutsalu.domain.Payment;
import com.ifutsalu.dto.payment.PaymentChargeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Tag(name = "PaymentController", description = "결제 컨트롤러")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    /**
     * 포인트 충전
     */
    @Operation(summary = "포인트 충전", description = "포인트를 충전합니다", tags = {"PaymentController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping("/charge")
    public ResponseEntity<?> chargePoints(@RequestBody PaymentChargeDto paymentChargeDto) {
        Payment payment = new Payment(paymentChargeDto.getAmount(), paymentChargeDto.getPaymentTime());

        return ResponseEntity.ok(payment);
    }

    /**
     * 결제내역 조회
     */
    @Operation(summary = "결제 내역 조회", description = "사용자의 결제 내역을 조회합니다", tags = {"PaymentController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/history/{userId}")
    public ResponseEntity<?> getPaymentHistory(@PathVariable Long userId) {
        List<Payment> paymentHistory = Arrays.asList(
                new Payment(new BigDecimal("20000"), LocalDateTime.now().minusDays(2)),
                new Payment(new BigDecimal("30000"), LocalDateTime.now().minusDays(1))
        );

        return ResponseEntity.ok(paymentHistory);
    }

    /**
     * 결제 환불
     */
    @Operation(summary = "결제 환불", description = "결제를 환불합니다", tags = {"PaymentController"})
    @ApiResponse(responseCode = "204", description = "No Content")
    @PostMapping("/refund/{paymentId}")
    public ResponseEntity<?> refundPayment(@PathVariable Long paymentId) {

        return ResponseEntity.noContent().build();
    }
}