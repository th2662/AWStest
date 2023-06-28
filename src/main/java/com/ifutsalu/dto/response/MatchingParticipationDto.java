package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchingParticipationDto {
    private Long matchId;
    private int price;


    public static MatchingParticipationDto fromMatchingParticipation(MatchParticipation participation) {
        Matching matching = participation.getMatch();
        return MatchingParticipationDto.builder()
                .matchId(matching.getId())
                .price(matching.getPrice())
                .build();
    }
}
