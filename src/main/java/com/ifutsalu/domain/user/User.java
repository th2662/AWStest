package com.ifutsalu.domain.user;

import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.dto.request.UpdateUserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "users")
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


    public void updateUserInfo(UpdateUserRequestDto userRequestDto) {
        if (userRequestDto.getProfileImageUrl() != null) {
            this.profileImageUrl = userRequestDto.getProfileImageUrl();
        }
        if (userRequestDto.getPassword() != null) {
            this.password = userRequestDto.getPassword();
        }
        if (userRequestDto.getAddress() != null) {
            this.address = userRequestDto.getAddress();
        }
        if (userRequestDto.getLevel() != null) {
            this.level = userRequestDto.getLevel();
        }
        if (userRequestDto.getPhone() != null) {
            this.phone = userRequestDto.getPhone();
        }
        if (userRequestDto.getRole() != null) {
            this.role = userRequestDto.getRole();
        }

    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void setMatchParticipations(List<MatchParticipation> matchParticipations) {
        this.matchParticipations = matchParticipations;
    }


}