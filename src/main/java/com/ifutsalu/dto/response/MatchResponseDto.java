package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.*;
import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MatchResponseDto {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private int minNumber;
    private int maxNumber;
    private int number;
    private Rule rule;
    private MatchStatus matchStatus;
    private LimitLevel limitLevel;
    private LimitShoes limitShoes;
    private LimitGender limitGender;
    private int price;
    private User manager;
    private Stadium stadium;

    public static MatchResponseDto fromEntity(Matching match) {
        return MatchResponseDto.builder()
                .id(match.getId())
                .startTime(match.getStartTime())
                .finishTime(match.getFinishTime())
                .minNumber(match.getMinNumber())
                .maxNumber(match.getMaxNumber())
                .number(match.getNumber())
                .rule(match.getRule())
                .matchStatus(match.getMatchStatus())
                .limitLevel(match.getLimitLevel())
                .limitShoes(match.getLimitShoes())
                .limitGender(match.getLimitGender())
                .price(match.getPrice())
                .manager(match.getManager())
                .stadium(match.getStadium())
                .build();
    }
}
