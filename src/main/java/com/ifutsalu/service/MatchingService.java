package com.ifutsalu.service;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.MatchingRepository;
import com.ifutsalu.domain.match.matchParticipation.MatchParticipationRepository;
import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.stadium.StadiumRepository;
import com.ifutsalu.domain.user.Role;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.domain.user.UserRepository;
import com.ifutsalu.dto.request.MatchingRequestDto;
import com.ifutsalu.dto.response.MatchResponseDto;
import com.ifutsalu.exception.CustomException;
import com.ifutsalu.exception.ErrorCode;
import com.ifutsalu.util.DateTimeFormatterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchingService {

    private final MatchParticipationRepository matchParticipationRepository;
    private final MatchingRepository matchingRepository;

    private final UserRepository userRepository;

    private final StadiumRepository stadiumRepository;

    @Transactional(readOnly = true)
    public MatchResponseDto createMatch(MatchingRequestDto matchingRequestDto) {

        Optional<User> user = userRepository.findById(Long.parseLong(matchingRequestDto.getUserId()));
        Optional<Stadium> stadium = stadiumRepository.findById(Long.parseLong(matchingRequestDto.getStadiumId()));

        LocalDateTime startTime = LocalDateTime.parse(matchingRequestDto.getStartTime(), DateTimeFormatterUtil.localDatePattern());
        LocalDateTime finishTime = LocalDateTime.parse(matchingRequestDto.getFinishTime(), DateTimeFormatterUtil.localDatePattern());

        if (user.isPresent() && stadium.isPresent()) {
            Matching matching = Matching.toEntity(matchingRequestDto, startTime, finishTime, user.get(), stadium.get());
            Matching result = matchingRepository.save(matching);

            return MatchResponseDto.fromEntity(result);
        }
        return MatchResponseDto.builder().build();
    }

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

        List<Matching> matches = matchingRepository.findByManager(user);
        return matches.stream()
                .map(MatchResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
