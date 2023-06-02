package com.ifutsalu.controller;

import com.ifutsalu.domain.Match;
import com.ifutsalu.domain.Stadium;
import com.ifutsalu.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "MatchController", description = "매치 컨트롤러")
@RestController
@RequestMapping("/match")
public class MatchController {

    private List<Match> matches;
    private List<User> users;

    public MatchController() {
        users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        matches = new ArrayList<>();
        matches.add(new Match(LocalDateTime.of(2023, 5, 10, 16, 00),
                LocalDateTime.of(2023, 5, 10, 18, 00),
                10, 15, Match.Rule.FIVE_VS_FIVE_THREE_TEAM, Match.LimitLevel.UNDER_AMATEUR,
                Match.LimitShoes.ALL, Match.LimitGender.ALL, new Stadium(), 20000, new User(), users));

        matches.add(new Match(LocalDateTime.of(2023, 5, 10, 16, 00),
                LocalDateTime.of(2023, 5, 10, 18, 00),
                10, 15, Match.Rule.FIVE_VS_FIVE_THREE_TEAM, Match.LimitLevel.UNDER_AMATEUR,
                Match.LimitShoes.ALL, Match.LimitGender.ALL, new Stadium(), 20000, new User(), users));
    }

    /**
     * 모든 매치 조회
     */
    @Operation(summary = "모든 매치 조회", description = "모든 매치 정보를 조회합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<?> getAllMatches() {

        return ResponseEntity.ok(matches);
    }

    /**
     * 매치 검색
     */
    @Operation(summary = "매치 검색", description = "키워드로 매치를 검색합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/search")
    public ResponseEntity<?> searchMatches(@RequestParam("keyword") String keyword) {

        return ResponseEntity.ok(matches);
    }

    /**
     * 매치 상세 정보 조회
     */
    @Operation(summary = "매치 상세 정보 조회", description = "매치의 상세 정보를 조회합니다", tags = {"MatchController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{matchId}")
    public ResponseEntity<?> getMatchById(@PathVariable Long matchId) {
        Match match = new Match(LocalDateTime.of(2023, 5, 10, 16, 00),
                LocalDateTime.of(2023, 5, 10, 18, 00),
                10, 15, Match.Rule.FIVE_VS_FIVE_THREE_TEAM, Match.LimitLevel.UNDER_AMATEUR,
                Match.LimitShoes.ALL, Match.LimitGender.ALL, new Stadium(), 20000, new User(), users);

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