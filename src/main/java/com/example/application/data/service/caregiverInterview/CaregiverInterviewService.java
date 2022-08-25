package com.example.application.data.service.caregiverInterview;

import com.example.application.data.entity.CaregiverInterview;
import com.example.application.data.entity.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CaregiverInterviewService implements CrudListener<CaregiverInterview> {
    private final CaregiverInterviewRepository repository;

    @Override
    public Collection<CaregiverInterview> findAll() {
        return repository.findAll();
    }

    @Override
    public CaregiverInterview add(CaregiverInterview caregiverInterview) {
        return repository.save(caregiverInterview);
    }

    @Override
    public CaregiverInterview update(CaregiverInterview caregiverInterview) {
        return repository.save(caregiverInterview);
    }

    @Override
    public void delete(CaregiverInterview caregiverInterview) {
        repository.delete(caregiverInterview);
    }

    public CaregiverInterview getCaregiverInterviewByClient(Long id) {
        return repository.findCaregiverInterviewByClient(id);
    }
}

