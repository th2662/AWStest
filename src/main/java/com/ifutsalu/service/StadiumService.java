package com.ifutsalu.service;

import com.ifutsalu.domain.stadium.Stadium;
import com.ifutsalu.domain.stadium.StadiumRepository;
import com.ifutsalu.dto.response.StadiumResponseDto;
import com.ifutsalu.exception.CustomException;
import com.ifutsalu.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    @Transactional(readOnly = true)
    public List<StadiumResponseDto> getAllStadiums() {
        List<Stadium> stadiums = stadiumRepository.findAll();
        return stadiums.stream()
                .map(StadiumResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StadiumResponseDto> searchStadiums(String keyword) {
        List<Stadium> stadiums = stadiumRepository.searchStadiums(keyword);
        return stadiums.stream()
                .map(StadiumResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StadiumResponseDto getStadiumDetail(Long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_STADIUM));
        return StadiumResponseDto.fromEntity(stadium);
    }
}
