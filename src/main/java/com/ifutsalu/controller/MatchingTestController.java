package com.ifutsalu.controller;

import com.ifutsalu.domain.match.*;
import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.dto.response.MatchResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matchTest")
public class MatchingTestController {

    // private final MatchingService matchingService;

    @Operation(summary = "예약 매칭 목록 조회", description = "특정 유저가 예약한 매칭 목록을 조회합니다", tags = {"MatchingTestController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getMatchesByUserId(@PathVariable("userId") Long userId) {
        // List<MatchResponseDto> matchResponseDtos = matchingService.getMatchesByUserId(userId);
        List<MatchResponseDto> matchResponseDtos = createMockMatches(userId);
        return ResponseEntity.ok(matchResponseDtos);
    }

    @Operation(summary = "매니저 담당 매칭 목록 조회", description = "특정 매니저가 담당하고 있는 매칭 목록을 조회합니다", tags = {"MatchingTestController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/manager/{userId}")
    public ResponseEntity<?> getMatchesByManager(@PathVariable("userId") Long userId) {
        // List<MatchResponseDto> matchResponseDtos = matchingService.getMatchesByManager(userId);
        List<MatchResponseDto> matchResponseDtos = createMockMatches(userId);
        return ResponseEntity.ok(matchResponseDtos);
    }

    private List<MatchResponseDto> createMockMatches(Long userId) {
        List<MatchResponseDto> mockMatches = new ArrayList<>();
        mockMatches.add(MatchResponseDto.builder()
                .id(1L)
                .startTime(LocalDateTime.now())
                .finishTime(LocalDateTime.now().plusHours(2))
                .minNumber(6)
                .maxNumber(12)
                .number(8)
                .rule(Rule.FIVE_VS_FIVE_TWO_TEAM)
                .matchStatus(MatchStatus.OPEN)
                .limitLevel(LimitLevel.UPPER_AMATEUR)
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES)
                .limitGender(LimitGender.ALL)
                .price(10000)
                .manager(User.builder().id(1L).name("정성현").role(Role.ROLE_MANAGER).build())
                .stadium(Stadium.builder().id(1L).name("난지천 풋살장").build())
                .build());
        return mockMatches;
    }
}
