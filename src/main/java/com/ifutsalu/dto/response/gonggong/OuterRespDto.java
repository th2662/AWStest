package com.ifutsalu.dto.response.gonggong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OuterRespDto {
    @JsonProperty(value = "ListPublicReservationSport")
    RespResultDto data;
}
