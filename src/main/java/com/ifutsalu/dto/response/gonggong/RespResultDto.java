package com.ifutsalu.dto.response.gonggong;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Getter;

/**
 * 참고 URL : http://data.seoul.go.kr:8080/dataList/OA-2266/A/1/datasetView.do
 * 공공 데이터 openAPI Response Format
 */
@Getter
public class RespResultDto {

    @JsonProperty(value = "list_total_count")
    private String totalCnt;

    @JsonProperty(value = "RESULT")
    Map<String, String> status;

    @JsonProperty(value = "row")
    List<ServiceInfoDto> row;
}
