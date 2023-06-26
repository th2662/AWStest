package com.ifutsalu.dto.response;

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
    private List<String> stadiumImageUrl;
    private String address;
    private String size;
    private boolean showerRoom;
    private boolean shoesRental;
    private ParkingLot parkingLot;
    private String notification;

    public static StadiumResponseDto fromEntity(Stadium stadium) {
        List<String> imgUrls = List.of(stadium.getStadiumImageUrl().split("@@"));

        return StadiumResponseDto.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .stadiumImageUrl(imgUrls)
                .address(stadium.getAddress())
                .size(stadium.getSize())
                .showerRoom(stadium.isShowerRoom())
                .shoesRental(stadium.isShoesRental())
                .parkingLot(stadium.getParkingLot())
                .notification(stadium.getNotification())
                .build();
    }
}

