package com.ifutsalu.domain.stadium;

import com.ifutsalu.domain.match.Matching;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stadium {

    @Builder
    public Stadium(String name, String stadiumImageUrl,
                   String address, String size, boolean showerRoom,
                   boolean shoesRental, ParkingLot parkingLot, String notification) {
        this.name = name;
        this.stadiumImageUrl = stadiumImageUrl;
        this.address = address;
        this.size = size;
        this.showerRoom = showerRoom;
        this.shoesRental = shoesRental;
        this.parkingLot = parkingLot;
        this.notification = notification;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String stadiumImageUrl;

    private String address;

    private String size;

    private boolean showerRoom;

    private boolean shoesRental;

    @Enumerated(EnumType.STRING)
    private ParkingLot parkingLot;

    private String notification;

    @OneToMany(mappedBy = "stadium")
    List<Matching> matchings;
}