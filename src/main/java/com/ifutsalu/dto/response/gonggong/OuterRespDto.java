package com.ifutsalu.dto.response.gonggong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * 공공 데이터 openAPI Response Format
 */
@Getter
public class OuterRespDto {
    @JsonProperty(value = "ListPublicReservationSport")
    RespResultDto data;
}
