package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.review.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewDto {

    private Long id;
    private ReviewIdDto user;
    private ReviewMatchingDto match;
    private String title;
    private String content;
    private int rating;


    public static ReviewDto fromEntity(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .user(ReviewIdDto.fromUser(review.getUser()))
                .match(ReviewMatchingDto.fromMatch(review.getMatch()))
                .title(review.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
    }
}
