package com.ifutsalu.dto.response.gonggong;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * 공공 데이터 openAPI Response Format
 */
@Getter
public class ServiceInfoDto {

    @JsonProperty(value = "GUBUN")
    private String gubun;                   //

    @JsonProperty(value = "SVCID")
    private String svcId;                   // 서비스Id

    @JsonProperty(value = "MAXCLASSNM")
    private String largeCategory;           // 대분류

    @JsonProperty(value = "MINCLASSNM")
    private String smallCategory;           // 소분류

    @JsonProperty(value = "SVCSTATNM")
    private String matchStatus;             // 서비스 상태

    @JsonProperty(value = "SVCNM")
    private String matchTitle;              // 서비스명

    @JsonProperty(value = "PAYATNM")
    private String paymentGb;               // 결제방법

    @JsonProperty(value = "PLACENM")
    private String placeName;               // 장소명

    @JsonProperty(value = "USETGTINFO")
    private String useTargetInfo;           // 서비스대상

    @JsonProperty(value = "SVCURL")
    private String reservUrl;               // 바로가기URL

    @JsonProperty(value = "X")
    private String longitude;               // 경도

    @JsonProperty(value = "Y")
    private String latitude;                // 위도

    @JsonProperty(value = "SVCOPNBGNDT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.s")
    private LocalDateTime serviceStartDate; // 서비스개시시작일시

    @JsonProperty(value = "SVCOPNENDDT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.s")
    private LocalDateTime serviceCloseDate; // 서비스개시종료일시

    @JsonProperty(value = "RCPTBGNDT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.s")
    private LocalDateTime reservStartDate;  // 접수시작일시

    @JsonProperty(value = "RCPTENDDT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.s")
    private LocalDateTime reservCloseDate;  // 접수종료일시

    @JsonProperty(value = "AREANM")
    private String areaName;                // 지역명 (마포구, 강남구)

    @JsonProperty(value = "IMGURL")
    private String imgUrl;                  // 대표 이미지 URL

    @JsonProperty(value = "DTLCONT")
    private String description;             // 상세정보

    @JsonProperty(value = "TELNO")          // 전화번호
    private String tel;

    @JsonProperty(value = "V_MIN")          // 서비스이용 시작시각
    private String startTime;

    @JsonProperty(value = "V_MAX")          // 서비스이용 종료시각
    private String endTime;

    @JsonProperty(value = "REVSTDDAYNM")    // 취소시간 기준정보
    private String cancelStdInfo;

    @JsonProperty(value = "REVSTDDAY")      // 취소시간 기준일까지
    private String cancelRangeInfo;         // 취소시간 범위
}
