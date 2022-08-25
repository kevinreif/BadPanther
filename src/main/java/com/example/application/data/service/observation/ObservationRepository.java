package com.example.application.data.service.observation;

import com.example.application.data.entity.ClientInfo;
import com.example.application.data.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {
    @Query("select c from Observation c " +
            "where c.clientID = :clientID")
    Observation findObservationByClient(@Param("clientID") Long id);
}
