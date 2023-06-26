package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.Matching;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewMatchingDto {

    private Long id;

    public static ReviewMatchingDto fromMatch(Matching match) {
        return ReviewMatchingDto.builder()
                .id(match.getId())
                .build();
    }
}
