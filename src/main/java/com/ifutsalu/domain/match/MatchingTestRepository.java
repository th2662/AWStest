package com.ifutsalu.domain.match;

import com.ifutsalu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingTestRepository extends JpaRepository<Matching, Long> {

    List<Matching> findByManager(User manager);
}
