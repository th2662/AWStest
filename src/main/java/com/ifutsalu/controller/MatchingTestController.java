package com.ifutsalu.controller;

import com.ifutsalu.domain.match.*;
import com.ifutsalu.dto.response.MatchResponseDto;
import com.ifutsalu.service.MatchingTestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "MatchingTestController", description = "매칭 테스트 컨트롤러")
@RequiredArgsConstructor
@RestController
@RequestMapping("/matchTest")
public class MatchingTestController {

    private final MatchingTestService matchingTestService;

    @Operation(summary = "예약 매칭 목록 조회", description = "특정 유저가 예약한 매칭 목록을 조회합니다", tags = {"MatchingTestController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getMatchesByUserId(@PathVariable("userId") Long userId) {
        List<MatchResponseDto> matchResponseDtos = matchingTestService.getMatchesByUserId(userId);
        // List<MatchResponseDto> matchResponseDtos = createMockMatches(userId);
        return ResponseEntity.ok(matchResponseDtos);
    }

    @Operation(summary = "매니저 담당 매칭 목록 조회", description = "특정 매니저가 담당하고 있는 매칭 목록을 조회합니다", tags = {"MatchingTestController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/manager/{userId}")
    public ResponseEntity<?> getMatchesByManager(@PathVariable("userId") Long userId) {
        List<MatchResponseDto> matchResponseDtos = matchingTestService.getMatchesByManager(userId);
        // List<MatchResponseDto> matchResponseDtos = createMockMatches(userId);
        return ResponseEntity.ok(matchResponseDtos);
    }

    private List<MatchResponseDto> createMockMatches(Long userId) {
        List<MatchResponseDto> mockMatches = new ArrayList<>();
        mockMatches.add(MatchResponseDto.builder()
                .startTime(LocalDateTime.now())
                .finishTime(LocalDateTime.now().plusHours(2))
                .minNumber(6)
                .maxNumber(12)
                .number(8)
                .rule(String.valueOf(Rule.FIVE_VS_FIVE_TWO_TEAM))
                .matchStatus(String.valueOf(MatchStatus.OPEN))
                .limitLevel(String.valueOf(LimitLevel.UPPER_AMATEUR))
                .limitShoes(String.valueOf(LimitShoes.ONLY_FUTSAL_SHOES))
                .limitGender(String.valueOf(LimitGender.ALL))
                .price(10000)
                .userId("1")
                .stadiumId("1")
                .build());
        return mockMatches;
    }
}
