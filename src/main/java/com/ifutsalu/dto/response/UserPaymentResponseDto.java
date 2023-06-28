package com.ifutsalu.dto.response;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class UserPaymentResponseDto {

    private Long userId;
    private String userName;
    private List<UserPayment> payments;
    private List<MatchingParticipationDto> matchingParticipations;

}
