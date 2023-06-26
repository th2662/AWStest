package com.ifutsalu.dto.response.gonggong;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class StadiumJsonDto {

    @JsonProperty(value = "DATA")
    List<StadiumInfoDto> data;
}

