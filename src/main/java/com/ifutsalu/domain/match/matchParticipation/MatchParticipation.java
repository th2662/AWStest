package com.ifutsalu.domain.match.matchParticipation;

import com.ifutsalu.domain.match.Matching;
import com.ifutsalu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "participation_uk",
                        columnNames = {"userId", "matchId"}
                )
        }
)
public class MatchParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "matchId")
    private Matching match;
}
