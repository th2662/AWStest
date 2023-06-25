package com.ifutsalu.domain.stadium;

import com.ifutsalu.domain.match.MatchTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    List<MatchTable> matchTables;
}