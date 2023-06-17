package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.Match;
import com.ifutsalu.domain.user.User;
import lombok.Getter;

@Getter
public class ReviewResponseDto {

    private User user;
    private Match match;
    private String content;
    private int rating;
}
