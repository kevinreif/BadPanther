package com.example.application.data.service.caregiverInterview;

import com.example.application.data.entity.CaregiverInterview;
import com.example.application.data.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaregiverInterviewRepository extends JpaRepository<CaregiverInterview, Long> {
    @Query("select c from CaregiverInterview c " +
            "where c.clientID = :clientID")
    CaregiverInterview findCaregiverInterviewByClient(@Param("clientID") Long id);
}
