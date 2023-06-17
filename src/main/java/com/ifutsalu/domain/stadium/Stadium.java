package com.ifutsalu.domain.stadium;

import com.ifutsalu.domain.match.Match;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stadium {

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
    List<Match> matches;
}