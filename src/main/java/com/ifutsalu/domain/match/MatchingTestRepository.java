package com.ifutsalu.domain.match;

import com.ifutsalu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchingTestRepository extends JpaRepository<Matching, Long> {

    List<Matching> findByManager(User manager);

    @Query("SELECT m FROM Matching m WHERE m.startTime > :startTime")
    List<Matching> getMatchByDate(@Param("startTime") String startTime);
}
