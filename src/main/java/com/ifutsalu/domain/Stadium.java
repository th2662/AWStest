package com.ifutsalu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Stadium {

    public enum ParkingLot {
        NONE, PAID, FREE
    }

    private String name;
    private String address;
    private String size;
    private boolean showerRoom;
    private boolean shoesRental;
    private ParkingLot parkingLot;
    private String notification;
}