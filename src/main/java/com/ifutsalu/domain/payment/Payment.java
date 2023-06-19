package com.ifutsalu.domain.payment;

import com.ifutsalu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDateTime paymentTime;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @PrePersist
    public void paymentTime() {
        this.paymentTime = LocalDateTime.now();
    }
}