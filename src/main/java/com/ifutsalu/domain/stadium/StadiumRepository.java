package com.ifutsalu.domain.stadium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    @Query("SELECT s FROM Stadium s WHERE s.name LIKE %:keyword%")
    List<Stadium> searchStadiums(@Param(" keyword") String keyword);
}
