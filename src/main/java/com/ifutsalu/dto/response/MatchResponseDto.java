package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.*;
import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MatchResponseDto {

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
}
