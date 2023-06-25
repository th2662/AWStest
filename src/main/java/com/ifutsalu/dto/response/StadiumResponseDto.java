package com.ifutsalu.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.stadium.ParkingLot;
import com.ifutsalu.domain.stadium.Stadium;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StadiumResponseDto {

    private Long id;
    private String name;
    private String stadiumImageUrl;
    private String address;
    private String size;
    private boolean showerRoom;
    private boolean shoesRental;
    private ParkingLot parkingLot;
    private String notification;

    @JsonIgnoreProperties({"stadium"})
    List<Matching> matchings;

    public static StadiumResponseDto fromEntity(Stadium stadium) {
        return StadiumResponseDto.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .stadiumImageUrl(stadium.getStadiumImageUrl())
                .address(stadium.getAddress())
                .size(stadium.getSize())
                .showerRoom(stadium.isShowerRoom())
                .shoesRental(stadium.isShoesRental())
                .parkingLot(stadium.getParkingLot())
                .notification(stadium.getNotification())
                .matchings(stadium.getMatchings())
                .build();
    }
}

