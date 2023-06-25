package com.ifutsalu.controller;

import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.dto.request.ReviewRequestDto;
import com.ifutsalu.dto.response.CMRespDto;
import com.ifutsalu.dto.response.ReviewResponseDto;
import com.ifutsalu.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{matchId}")
    public ResponseEntity<?> uploadReview(@PathVariable("matchId") Long matchId, @RequestBody ReviewRequestDto reviewRequestDto) {
        reviewService.uploadReview(matchId, reviewRequestDto);
        return new ResponseEntity<>(new CMRespDto<>(1, "리뷰 작성 성공", null), HttpStatus.CREATED);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable("reviewId") Long reviewId, @RequestBody ReviewRequestDto reviewRequestDto) {
        ReviewResponseDto updatedReview = reviewService.updateReview(reviewId, reviewRequestDto);
        return new ResponseEntity<>(new CMRespDto<>(1, "리뷰 수정 성공", updatedReview), HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewId") Long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(new CMRespDto<>(1, "리뷰 삭제 성공", null), HttpStatus.NO_CONTENT);
    }
}
