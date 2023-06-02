package com.ifutsalu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Match {

    public enum Rule {
        FIVE_VS_FIVE_TWO_TEAM, FIVE_VS_FIVE_THREE_TEAM, SIX_VS_SIX_TWO_TEAM, SIX_VS_SIX_THREE_TEAM
    }

    public enum LimitLevel {
        ALL, ONLY_BEGINNER, UNDER_AMATEUR, ONLY_AMATEUR, UPPER_AMATEUR, ONLY_PRO
    }

    public enum LimitShoes {
        ALL, ONLY_FUTSAL_SHOES
    }

    public enum LimitGender {
        ALL, ONLY_MALE, ONLY_FEMALE
    }

    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private int min;
    private int max;
    private Rule rule;
    private LimitLevel level;
    private LimitShoes shoes;
    private LimitGender gender;
    private Stadium stadium;
    private int price;
    private User manager;
    private List<User> users;
}