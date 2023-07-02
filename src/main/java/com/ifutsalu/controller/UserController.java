package com.ifutsalu.controller;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.matchParticipation.MatchParticipation;
import com.ifutsalu.domain.match.review.Review;
import com.ifutsalu.domain.payment.Payment;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.dto.request.UserUpdateRequest;
import com.ifutsalu.dto.response.*;
import com.ifutsalu.service.UserService;
import com.ifutsalu.util.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "UserController", description = "유저 컨트롤러")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원 프로필 조회
     */
    @Operation(summary = "회원 프로필 조회", description = "회원 프로필을 조회합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> findUserInfoById() {
        return ResponseEntity.ok(userService.findUserInfoById(SecurityUtil.getCurrentUserId()));
    }

    /**
     * 회원 프로필 수정
     */
    @Operation(summary = "회원 프로필 수정", description = "회원 프로필을 수정합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/me")
    public ResponseEntity<UserUpdateResponse> updateUserInfo(@RequestBody UserUpdateRequest updateUserRequestDto) {
        Long userId = SecurityUtil.getCurrentUserId();
        UserUpdateResponse updatedUser = userService.updateUserInfo(userId, updateUserRequestDto);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * 회원 권한 매니저로 변경하기
     */
    @Operation(summary = "회원 권한 매니저로 수정", description = "회원 권한을 매니저로 수정합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
//    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/update/{userId}")
    public ResponseEntity<?> updateUserRole(@PathVariable Long userId) {
        userService.updateUserRole(userId);
        return ResponseEntity.ok().build();
    }

    /**
     * 유저가 작성한 리뷰 리스트 조회 API
     */
    @GetMapping("/{userId}/reviews")
    @Operation(summary = "특정 유저 리뷰 리스트 조회", description = "특정 유저가 사용한 작성한 리뷰 리스트를를 조회합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<List<ReviewDto>> getReviewByUser(@PathVariable Long userId) {
        // 목데이터 생성
        List<Review> reviews = createMockReviews(userId);

        if (reviews == null) {
            //리뷰를 찾을 수 없을 경우 예외처리
            return ResponseEntity.notFound().build();
        }

        List<ReviewDto> reviewResponses = reviews.stream()
                .map(ReviewDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewResponses);
    }
    private List<Review> createMockReviews(Long userId) {
        if (userId.equals(1L)) {

            User user = User.builder()
                    .id(userId)
                    .email("th8260@example.com")
                    .name("Mock User")

                    .build();

            Matching match1 = Matching.builder()
                    .id(1L)
                    .build();

            Matching match2 = Matching.builder()
                    .id(2L)
                    .build();

            Matching match3 = Matching.builder()
                    .id(3L)
                    .build();

            Review review1 = Review.builder()
                    .id(1L)
                    .user(user)
                    .match(match1)
                    .title("리뷰테스트1 ")
                    .content("좋은경기!!.")
                    .rating(4)
                    .build();

            Review review2 = Review.builder()
                    .id(2L)
                    .user(user)
                    .match(match2)
                    .title("리뷰테스트2")
                    .content("오늘은 별로였음2.")
                    .rating(3)
                    .build();


            Review review3 = Review.builder()
                    .id(3L)
                    .user(user)
                    .match(match3)
                    .title("리뷰테스트3")
                    .content("그저 그랬음.")
                    .rating(3)
                    .build();

            List<Review> reviews = new ArrayList<>();
            reviews.add(review1);
            reviews.add(review2);
            reviews.add(review3);
            return reviews;
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * 특정유저의 프로필 이미지와 잔액조회 API
     */
    @GetMapping("/{userId}/profile")
    @Operation(summary = "특정 유저의 프로필 조회", description = "특정 유저의 프로필 이미지와 잔액을 조회함", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable Long userId) {
        // 목데이터 생성
        List<User> users = createMockUsers();

        // userId에 해당하는 User 찾기
        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        UserProfileResponse userProfileResponse = UserProfileResponse.fromEntity(user);

        return ResponseEntity.ok(userProfileResponse);
    }


    private List<User> createMockUsers() {
        List<User> users = new ArrayList<>();

        // User 1
        User user1 = User.builder()
                .id(1L)
                .name("John")
                .profileImageUrl("https://example.com/profiles/john.jpg")
                .build();

        Payment payment1 = Payment.builder()
                .amount(new BigDecimal("10000"))
                .user(user1) // User와 Payment 간의 관계 설정
                .build();

        user1.setPayments(Collections.singletonList(payment1));
        users.add(user1);

        // User 2
        User user2 = User.builder()
                .id(2L)
                .name("Alice")
                .profileImageUrl("https://example.com/profiles/alice.jpg")
                .build();

        Payment payment2 = Payment.builder()
                .amount(new BigDecimal("9000"))
                .user(user2) // User와 Payment 간의 관계 설정
                .build();

        user2.setPayments(Collections.singletonList(payment2));
        users.add(user2);

        return users;
    }

    /**
     * 특정 유저 결제 내역 보기
     */
    @GetMapping("/{userId}/payments")
    @Operation(summary = "특정 유저의 결제 내역 조회", description = "특정 유저의 결제내역을 조회합니다", tags = {"UserController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<UserPaymentResponseDto> getUserPayments(@PathVariable Long userId) {
        // Mock 데이터 생성
        List<User> users = createPaymentUsers();

        // userId에 해당하는 User 찾기
        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<Payment> payments = user.getPayments();

        List<MatchingParticipationDto> matchingParticipations = new ArrayList<>();
        for (MatchParticipation participation : user.getMatchParticipations()) {
            MatchingParticipationDto dto = MatchingParticipationDto.fromMatchingParticipation(participation);
            matchingParticipations.add(dto);
        }

        UserPaymentResponseDto userPaymentResponseDto = UserPaymentResponseDto.builder()
                .userId(user.getId())
                .userName(user.getName())
                .payments(UserPayment.fromPayments(payments))
                .matchingParticipations(matchingParticipations)
                .build();

        return ResponseEntity.ok(userPaymentResponseDto);
    }

    private List<User> createPaymentUsers() {
        List<User> users = new ArrayList<>();

        // User 1
        User user1 = User.builder()
                .id(1L)
                .name("John")
                .build();

        Payment payment1 = Payment.builder()
                .id(1L)
                .paymentTime(LocalDateTime.now())
                .user(user1)
                .build();

        Payment payment2 = Payment.builder()
                .id(2L)
                .paymentTime(LocalDateTime.now().minusHours(1))
                .user(user1)
                .build();

        Matching matching1 = Matching.builder()
                .id(1L)
                .price(10000)
                .build();

        Matching matching2 = Matching.builder()
                .id(2L)
                .price(5000)
                .build();

        MatchParticipation matchParticipation1 = MatchParticipation.builder()
                .user(user1)
                .match(matching1)
                .build();

        MatchParticipation matchParticipation2 = MatchParticipation.builder()
                .user(user1)
                .match(matching2)
                .build();

        // User 2
        User user2 = User.builder()
                .id(2L)
                .name("Jane")
                .build();

        Payment payment3 = Payment.builder()
                .id(3L)
                .paymentTime(LocalDateTime.now().minusHours(2))
                .user(user2)
                .build();

        Matching matching3 = Matching.builder()
                .id(3L)
                .price(150)
                .build();

        MatchParticipation matchParticipation3 = MatchParticipation.builder()
                .user(user2)
                .match(matching3)
                .build();

        user1.setPayments(Arrays.asList(payment1, payment2));
        user1.setMatchParticipations(Arrays.asList(matchParticipation1, matchParticipation2));
        user2.setPayments(Collections.singletonList(payment3));
        user2.setMatchParticipations(Collections.singletonList(matchParticipation3));

        users.add(user1);
        users.add(user2);

        return users;
    }

}