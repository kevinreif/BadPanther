package com.example.application.data.service.dailyLivingSkills;

import com.example.application.data.entity.DailyLivingSkills;
import com.example.application.data.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyLivingSkillsRepository extends JpaRepository<DailyLivingSkills, Long> {
    @Query("select c from DailyLivingSkills c " +
            "where c.clientID = :clientID")
    DailyLivingSkills findDailyLivingSkillsByClient(@Param("clientID") Long id);
}

