package com.example.application.data.service.summaryOfHistory;

import com.example.application.data.entity.Observation;
import com.example.application.data.entity.SummaryOfHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryOfHistoryRepository extends JpaRepository<SummaryOfHistory, Long> {
    @Query("select c from SummaryOfHistory c " +
            "where c.clientID = :clientID")
    SummaryOfHistory findSummaryOfHistoryByClient(@Param("clientID") Long id);
}
