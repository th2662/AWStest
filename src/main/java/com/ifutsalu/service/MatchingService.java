package com.ifutsalu.service;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.match.MatchingRepository;
import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.stadium.StadiumRepository;
import com.ifutsalu.domain.user.User;
import com.ifutsalu.domain.user.UserRepository;
import com.ifutsalu.dto.request.MatchingRequestDto;
import com.ifutsalu.dto.response.MatchResponseDto;
import com.ifutsalu.util.DateTimeFormatterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchingService {

    private final MatchingRepository matchingRepository;

    private final UserRepository userRepository;

    private final StadiumRepository stadiumRepository;

    public List<MatchResponseDto> getMatchByDate() {


        return null;
    }

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

}
