package com.ifutsalu.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class MatchingRequestDto {
    @NotBlank
    @JsonProperty(value = "start_time")
    private String startTime;

    @NotBlank
    @JsonProperty(value = "finish_time")
    private String finishTime;

    @NotBlank
    @JsonProperty(value = "min_number")
    private String minNumber;

    @NotBlank
    @JsonProperty(value = "max_number")
    private String maxNumber;

    @NotBlank
    private int number;

    @NotBlank
    private String rule;

    @NotBlank
    @JsonProperty(value = "limit_level")
    private String limitLevel;

    @NotBlank
    @JsonProperty(value = "limit_shoes")
    private String limitShoes;

    @NotBlank
    @JsonProperty(value = "limit_gender")
    private String limitGender;

    @NotBlank
    private String price;

    @NotBlank
    @JsonProperty(value = "user_id")
    private String userId;

    @NotBlank
    @JsonProperty(value = "stadium_id")
    private String stadiumId;

}
