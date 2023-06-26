package com.ifutsalu.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WeeklyMatchResponseDto {
    List<MatchResponseDto> mon;
    List<MatchResponseDto> tue;
    List<MatchResponseDto> wed;
    List<MatchResponseDto> thu;
    List<MatchResponseDto> fri;
    List<MatchResponseDto> sat;
    List<MatchResponseDto> sun;
}
