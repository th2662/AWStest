package com.ifutsalu.controller;

import com.ifutsalu.domain.Match;
import com.ifutsalu.domain.Stadium;
import com.ifutsalu.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> getAllMatches() {

        return ResponseEntity.ok(matches);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchMatches(@RequestParam("keyword") String keyword) {

        return ResponseEntity.ok(matches);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<?> getMatchById(@PathVariable Long matchId) {
        Match match = new Match(LocalDateTime.of(2023, 5, 10, 16, 00),
                LocalDateTime.of(2023, 5, 10, 18, 00),
                10, 15, Match.Rule.FIVE_VS_FIVE_THREE_TEAM, Match.LimitLevel.UNDER_AMATEUR,
                Match.LimitShoes.ALL, Match.LimitGender.ALL, new Stadium(), 20000, new User(), users);

        return ResponseEntity.ok(match);
    }

    @PostMapping("/{matchId}/apply")
    public ResponseEntity<?> applyMatch(@PathVariable Long matchId) {

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{matchId}/cancel")
    public ResponseEntity<?> cancelMatch(@PathVariable Long matchId) {

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{matchId}/likes")
    public ResponseEntity<?> likes(@PathVariable int matchId) {

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{matchId}/likes")
    public ResponseEntity<?> unlikes(@PathVariable int matchId) {

        return ResponseEntity.noContent().build();
    }
}