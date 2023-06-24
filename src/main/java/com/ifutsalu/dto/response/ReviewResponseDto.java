package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.MatchTable;
import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDto {

    private Long id;
    private User user;
    private MatchTable match;
    private String title;
    private String content;
    private int rating;

    public static ReviewResponseDto fromEntity(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .user(review.getUser())
                .match(review.getMatch())
                .title(review.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
    }
}
