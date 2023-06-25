package com.ifutsalu.dto.request;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.user.User;
import lombok.Getter;

@Getter
public class ReviewRequestDto {

    private User user;
    private Matching match;
    private String title;
    private String content;
    private int rating;

    public Review toEntity() {
        return Review.builder()
                .user(user)
                .match(match)
                .title(title)
                .content(content)
                .rating(rating)
                .build();
    }
}
