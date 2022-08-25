package com.example.application.data.service.behavior;

import com.example.application.data.entity.Behavior;
import com.example.application.data.entity.CaregiverInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BehaviorRepository extends JpaRepository<Behavior, Long> {
    @Query("select c from Behavior c " +
            "where c.clientID = :clientID")
    List<Behavior> findBehaviorsByClient(@Param("clientID") Long id);

    /*@Query("select c from Behavior c " +
            "where c.clientID = :clientID")
    Behavior findBehaviorsByClient(@Param("clientID") Long id);*/
}
