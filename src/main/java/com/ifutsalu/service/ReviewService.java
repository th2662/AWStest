package com.ifutsalu.service;

import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.match.review.ReviewRepository;
import com.ifutsalu.dto.request.ReviewRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public void uploadReview(ReviewRequestDto reviewRequestDto) {
        Review review = reviewRequestDto.toEntity();
        reviewRepository.save(review);
    }
}
