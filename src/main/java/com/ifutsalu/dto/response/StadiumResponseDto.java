package com.ifutsalu.dto.response;

import com.ifutsalu.domain.stadium.ParkingLot;
import lombok.Getter;

@Getter
public class StadiumResponseDto {

    private String name;
    private String stadiumImageUrl;
    private String address;
    private String size;
    private boolean showerRoom;
    private boolean shoesRental;
    private ParkingLot parkingLot;
    private String notification;
}
