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


    // TODO: 추후 적용 예정 (Entity2Dto)
    public static MatchResponseDto fromEntity(Matching matching) {
        return null;
    }
}