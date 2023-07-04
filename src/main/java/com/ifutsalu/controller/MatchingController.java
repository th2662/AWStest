package com.ifutsalu.controller;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.dto.response.WeeklyMatchResponseDto;
import com.ifutsalu.service.MatchDummyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "MatchController", description = "매치 컨트롤러")
@RequiredArgsConstructor
@RestController
@RequestMapping("/match")
public class MatchingController {
    private final MatchDummyService matchDummyService;

    /**
     * 오늘 날짜 기준으로 일주일치에 해당하는 매칭 정보 제공
     */
    @Operation(summary = "오늘 날짜 기준으로 일주일치 매칭 정보 제공", description = "일주일 분량의 매칭 정보를 제공합니다.", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "요일 별 매칭 정보를 반환합니다.")
    @GetMapping("/weekly")
    public ResponseEntity<WeeklyMatchResponseDto> getWeekMatches() {
        return ResponseEntity.ok(matchDummyService.mockMatchResponseData());
    }

    /**
     * 모든 매치 조회
     */
    @Operation(summary = "모든 매치 조회", description = "모든 매치 정보를 조회합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<?> getAllMatches() {

        return ResponseEntity.ok().build();
    }

    /**
     * 매치 검색
     */
    @Operation(summary = "매치 검색", description = "키워드로 매치를 검색합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/search")
    public ResponseEntity<?> searchMatches(@RequestParam("keyword") String keyword) {

        return ResponseEntity.ok().build();
    }

    /**
     * 매치 상세 정보 조회
     */
    @Operation(summary = "매치 상세 정보 조회", description = "매치의 상세 정보를 조회합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{matchId}")
    public ResponseEntity<?> getMatchById(@PathVariable Long matchId) {
        Matching match = new Matching();
        return ResponseEntity.ok(match);
    }

    /**
     * 매치 신청
     */
    @Operation(summary = "매치 신청", description = "매치에 신청합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "204", description = "No Content")
    @PostMapping("/{matchId}/apply")
    public ResponseEntity<?> applyMatch(@PathVariable Long matchId) {

        return ResponseEntity.noContent().build();
    }

    /**
     * 매치 취소
     */
    @Operation(summary = "매치 취소", description = "매치 신청을 취소합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "204", description = "No Content")
    @DeleteMapping("/{matchId}/cancel")
    public ResponseEntity<?> cancelMatch(@PathVariable Long matchId) {

        return ResponseEntity.noContent().build();
    }

    /**
     * 매치 좋아요
     */
    @Operation(summary = "매치 좋아요", description = "매치에 좋아요를 누릅니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "204", description = "No Content")
    @PostMapping("/{matchId}/likes")
    public ResponseEntity<?> likes(@PathVariable int matchId) {

        return ResponseEntity.noContent().build();
    }

    /**
     * 매치 좋아요 취소
     */
    @Operation(summary = "매치 좋아요 취소", description = "매치에 누른 좋아요를 취소합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "204", description = "No Content")
    @DeleteMapping("/{matchId}/likes")
    public ResponseEntity<?> unlikes(@PathVariable int matchId) {

        return ResponseEntity.noContent().build();
    }
}