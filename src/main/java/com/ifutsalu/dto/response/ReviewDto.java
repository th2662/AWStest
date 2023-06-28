package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.review.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewDto {

    private Long id;
    private Long userId;
    private String userEmail;
    private String userName;
    private Long matchId;
    private String title;
    private String content;
    private int rating;


    public static ReviewDto fromEntity(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .userId(review.getUser().getId())
                .userEmail(review.getUser().getEmail())
                .userName(review.getUser().getName())
                .matchId(review.getMatch().getId())
                .title(review.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
    }
}
