package com.ifutsalu.domain.user;

import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import com.ifutsalu.domain.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true)
    private String email;

    private String profileImageUrl;

    private String password;

    private String name;

    private String address;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate birth;

    @OneToMany(mappedBy = "user")
    private List<MatchParticipation> matchParticipations;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;
}