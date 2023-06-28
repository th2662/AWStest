package com.ifutsalu.domain.match.matchParticipation;

import com.ifutsalu.domain.match.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchParticipationRepository extends JpaRepository<MatchParticipation, Long> {

    @Query("SELECT mp.match FROM MatchParticipation mp WHERE mp.user.id = :userId")
    List<Matching> findMatchesByUserId(@Param("userId") Long userId);
}
