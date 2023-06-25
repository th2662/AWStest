package com.ifutsalu.service;

import com.ifutsalu.domain.match.MatchingRepository;
import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.match.review.ReviewRepository;
import com.ifutsalu.dto.request.ReviewRequestDto;
import com.ifutsalu.dto.response.ReviewResponseDto;
import com.ifutsalu.exception.CustomException;
import com.ifutsalu.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MatchingRepository matchingRepository;

    @Transactional
    public void uploadReview(Long matchId, ReviewRequestDto reviewRequestDto) {
        Matching match = matchingRepository.findById(matchId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_MATCH));
        Review review = Review.builder()
                .user(reviewRequestDto.getUser())
                .match(match)
                .title(reviewRequestDto.getTitle())
                .content(reviewRequestDto.getContent())
                .rating(reviewRequestDto.getRating())
                .build();
        reviewRepository.save(review);
    }

    @Transactional
    public ReviewResponseDto updateReview(Long reviewId, ReviewRequestDto reviewRequestDto) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_REVIEW));

        Review updatedReview = Review.builder()
                .id(review.getId())
                .user(reviewRequestDto.getUser())
                .match(review.getMatch())
                .title(reviewRequestDto.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
        reviewRepository.save(updatedReview);
        return ReviewResponseDto.fromEntity(updatedReview);
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new CustomException(ErrorCode.NOT_FOUND_REVIEW);
        }
        reviewRepository.deleteById(reviewId);
    }
}
