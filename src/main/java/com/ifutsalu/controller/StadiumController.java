package com.ifutsalu.controller;

import com.ifutsalu.dto.response.CMRespDto;
import com.ifutsalu.dto.response.StadiumResponseDto;
import com.ifutsalu.service.StadiumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "StadiumController", description = "구장 컨트롤러")
@RequiredArgsConstructor
@RestController
@RequestMapping("/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    /**
     * 모든 구장 조회
     */
    @Operation(summary = "모든 구장 조회", description = "모든 구장 정보를 조회합니다", tags = {"StadiumController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<?> getAllStadiums() {
        List<StadiumResponseDto> stadiums = stadiumService.getAllStadiums();
        return new ResponseEntity<>(new CMRespDto<>(1, "모든 구장 조회 성공", stadiums), HttpStatus.OK);
    }

    /**
     * 구장 검색
     */
    @Operation(summary = "구장 검색", description = "키워드로 구장을 검색합니다", tags = {"StadiumController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/search")
    public ResponseEntity<?> searchStadiums(@RequestParam("keyword") String keyword) {
        List<StadiumResponseDto> stadiums = stadiumService.searchStadiums(keyword);
        return new ResponseEntity<>(new CMRespDto<>(1, "구장 검색 성공", stadiums), HttpStatus.OK);
    }

    /**
     * 구장 상세정보 조회
     */
    @Operation(summary = "구장 상세정보 조회", description = "구장 상세정보를 조회합니다", tags = {"StadiumController"})
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{stadiumId}")
    public ResponseEntity<?> getStadiumDetail(@PathVariable("stadiumId") Long stadiumId) {
        StadiumResponseDto stadium = stadiumService.getStadiumDetail(stadiumId);
        return new ResponseEntity<>(new CMRespDto<>(1, "구장 상세정보 조회 성공", stadium), HttpStatus.OK);
    }
}