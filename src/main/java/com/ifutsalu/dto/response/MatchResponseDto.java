package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class MatchResponseDto {

    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private int minNumber;
    private int maxNumber;
    private int number;
    private String rule;
    private String matchStatus;
    private String limitLevel;
    private String limitShoes;
    private String limitGender;
    private int price;
    private String userId;
    private String stadiumId;

    public static MatchResponseDto fromEntity(Matching matching) {
        return MatchResponseDto.builder()
                .startTime(matching.getStartTime())
                .finishTime(matching.getFinishTime())
                .minNumber(matching.getMinNumber())
                .maxNumber(matching.getMaxNumber())
                .number(matching.getNumber())
                .rule(matching.getRule().name())
                .matchStatus(matching.getMatchStatus().name())
                .limitLevel(matching.getLimitLevel().name())
                .limitShoes(matching.getLimitShoes().name())
                .limitGender(matching.getLimitGender().name())
                .price(matching.getPrice())
                .userId(matching.getManager().getId().toString())
                .stadiumId(matching.getStadium().getId().toString())
                .build();
    }
}
