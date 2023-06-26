package com.ifutsalu.domain.user;

import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.dto.request.UpdateUserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .profileImageUrl(profileImageUrl)
                .password(passwordEncoder.encode(password))
                .name(name)
                .address(address)
                .level(level)
                .phone(phone)
                .gender(gender)
                .role(Role.ROLE_USER)
                .birth(birth)
                .build();
    }

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


}