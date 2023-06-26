package com.ifutsalu.service;

import com.ifutsalu.domain.match.LimitGender;
import com.ifutsalu.domain.match.LimitLevel;
import com.ifutsalu.domain.match.LimitShoes;
import com.ifutsalu.domain.match.MatchStatus;
import com.ifutsalu.dto.response.MatchResponseDto;
import com.ifutsalu.dto.response.WeeklyMatchResponseDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MatchDummyService {
    public WeeklyMatchResponseDto mockMatchResponseData() {
        // 하루에 3타임 기준
        LocalDateTime startTime0 = LocalDateTime.of(2023, 06, 26, 16, 00);
        LocalDateTime endTime0 = LocalDateTime.of(2023, 06, 26, 18, 00);

        LocalDateTime startTime1 = LocalDateTime.of(2023, 06, 26, 18, 00);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 06, 26, 20, 00);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 06, 26, 20, 00);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 06, 26, 22, 00);

        MatchResponseDto data1 = MatchResponseDto.builder()
                .startTime(startTime0)
                .finishTime(endTime0)
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("67")
                .build();

        MatchResponseDto data2 = MatchResponseDto.builder()
                .startTime(startTime1)
                .finishTime(endTime1)
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("67")
                .build();

        MatchResponseDto data3 = MatchResponseDto.builder()
                .startTime(startTime0.plusDays(1))
                .finishTime(endTime0.plusDays(1))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("75")
                .build();

        MatchResponseDto data4 = MatchResponseDto.builder()
                .startTime(startTime1.plusDays(1))
                .finishTime(endTime1.plusDays(1))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("75")
                .build();

        MatchResponseDto data5 = MatchResponseDto.builder()
                .startTime(startTime0.plusDays(2))
                .finishTime(endTime0.plusDays(2))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("81")
                .build();

        MatchResponseDto data6 = MatchResponseDto.builder()
                .startTime(startTime1.plusDays(2))
                .finishTime(endTime1.plusDays(2))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("81")
                .build();

        MatchResponseDto data7 = MatchResponseDto.builder()
                .startTime(startTime0.plusDays(3))
                .finishTime(endTime0.plusDays(3))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("81")
                .build();

        MatchResponseDto data8 = MatchResponseDto.builder()
                .startTime(startTime1.plusDays(3))
                .finishTime(endTime1.plusDays(3))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("81")
                .build();

        MatchResponseDto data9 = MatchResponseDto.builder()
                .startTime(startTime0.plusDays(5))
                .finishTime(endTime0.plusDays(5))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("88")
                .build();

        MatchResponseDto data10 = MatchResponseDto.builder()
                .startTime(startTime0.plusDays(5))
                .finishTime(endTime0.plusDays(5))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("79")
                .build();

        MatchResponseDto data11 = MatchResponseDto.builder()
                .startTime(startTime2.plusDays(5))
                .finishTime(endTime2.plusDays(5))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("76")
                .build();

        MatchResponseDto data12 = MatchResponseDto.builder()
                .startTime(startTime2.plusDays(6))
                .finishTime(endTime2.plusDays(6))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("84")
                .build();

        MatchResponseDto data13 = MatchResponseDto.builder()
                .startTime(startTime2.plusDays(6))
                .finishTime(endTime2.plusDays(6))
                .minNumber(6)
                .maxNumber(12)
                .rule("test Rule입니다.")
                .matchStatus(MatchStatus.OPEN.toString())
                .limitLevel(LimitLevel.ONLY_AMATEUR.toString())
                .limitShoes(LimitShoes.ONLY_FUTSAL_SHOES.toString())
                .limitGender(LimitGender.ONLY_MALE.toString())
                .price(10000)
                .userId("Mock User Id")
                .stadiumId("70")
                .build();

        WeeklyMatchResponseDto result = WeeklyMatchResponseDto.builder()
                .mon(List.of(data1, data2))
                .tue(List.of(data3, data4))
                .wed(List.of(data5, data6))
                .thu(List.of(data7, data8))
                .fri(List.of())
                .sat(List.of(data9, data10, data11))
                .sun(List.of(data12, data13))
                .build();
        return result;
    }
}
