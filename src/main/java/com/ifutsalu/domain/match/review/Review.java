package com.ifutsalu.domain.match.review;

import com.ifutsalu.domain.match.Match;
import com.ifutsalu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "review_uk",
                        columnNames = {"userId", "matchId"}
                )
        }
)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "matchId")
    private Match match;

    private String content;

    private int rating;
}
