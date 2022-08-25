package com.example.application.data.service.dailyLivingSkills;

import com.example.application.data.entity.DailyLivingSkills;
import com.example.application.data.entity.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class DailyLivingSkillsService implements CrudListener<DailyLivingSkills> {

    private final DailyLivingSkillsRepository repository;

    @Override
    public Collection<DailyLivingSkills> findAll() {
        return repository.findAll();
    }

    @Override
    public DailyLivingSkills add(DailyLivingSkills dailyLivingSkills) {
        return repository.save(dailyLivingSkills);
    }

    @Override
    public DailyLivingSkills update(DailyLivingSkills dailyLivingSkills) {
        return repository.save(dailyLivingSkills);
    }

    @Override
    public void delete(DailyLivingSkills dailyLivingSkills) {
        repository.delete(dailyLivingSkills);
    }

    public DailyLivingSkills getDailyLivingSkillsByClient(Long id) {
        return repository.findDailyLivingSkillsByClient(id);
    }
}
