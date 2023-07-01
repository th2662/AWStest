package com.ifutsalu.service;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.MatchingTestRepository;
import com.ifutsalu.domain.match.matchParticipation.MatchParticipationRepository;
import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.domain.user.UserRepository;
import com.ifutsalu.dto.response.MatchResponseDto;
import com.ifutsalu.exception.CustomException;
import com.ifutsalu.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchingTestService {

    private final MatchParticipationRepository matchParticipationRepository;
    private final UserRepository userRepository;
    private final MatchingTestRepository matchingTestRepository;

    @Transactional(readOnly = true)
    public List<MatchResponseDto> getMatchesByUserId(Long userId) {
        List<Matching> matches = matchParticipationRepository.findMatchesByUserId(userId);
        List<MatchResponseDto> matchResponseDtos = new ArrayList<>();
        for (Matching match : matches) {
            matchResponseDtos.add(MatchResponseDto.fromEntity(match));
        }
        return matchResponseDtos;
    }

    @Transactional(readOnly = true)
    public List<MatchResponseDto> getMatchesByManager(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));
        if (user.getRole() != Role.ROLE_MANAGER) {
            throw new CustomException(ErrorCode.FORBIDDEN_MEMBER);
        }

        List<Matching> matches = matchingTestRepository.findByManager(user);
        return matches.stream()
                .map(MatchResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
