package com.ifutsalu.domain.match;

import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.dto.request.MatchingRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Matching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    private int minNumber;

    private int maxNumber;

    private int number;

    @Enumerated(EnumType.STRING)
    private Rule rule;

    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;

    @Enumerated(EnumType.STRING)
    private LimitLevel limitLevel;

    @Enumerated(EnumType.STRING)
    private LimitShoes limitShoes;

    @Enumerated(EnumType.STRING)
    private LimitGender limitGender;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId")
    private User manager;

    @ManyToOne
    @JoinColumn(name = "stadiumId")
    private Stadium stadium;

    @OneToMany(mappedBy = "match")
    private List<MatchParticipation> matchParticipations;

    @OneToMany(mappedBy = "match")
    private List<Review> reviews;

    public static Matching toEntity(MatchingRequestDto dto, LocalDateTime startTime,
                                    LocalDateTime finishTime, User user, Stadium stadium) {
        return Matching.builder()
                .startTime(startTime)
                .finishTime(finishTime)
                .minNumber(Integer.parseInt(dto.getMinNumber()))
                .maxNumber(Integer.parseInt(dto.getMaxNumber()))
                .number(dto.getNumber())
                .rule(Rule.valueOf(dto.getRule()))
                .matchStatus(MatchStatus.OPEN)
                .limitLevel(LimitLevel.valueOf(dto.getLimitLevel()))
                .limitShoes(LimitShoes.valueOf(dto.getLimitShoes()))
                .limitGender(LimitGender.valueOf(dto.getLimitGender()))
                .price(Integer.parseInt(dto.getPrice()))
                .manager(user)
                .stadium(stadium)
                .build();
    }
}