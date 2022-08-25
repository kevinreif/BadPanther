package com.example.application.data.service.observation;

import com.example.application.data.entity.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ObservationService implements CrudListener<Observation> {
    private final ObservationRepository repository;

    @Override
    public Collection<Observation> findAll() {
        return repository.findAll();
    }

    @Override
    public Observation add(Observation observation) {
        return repository.save(observation);
    }

    @Override
    public Observation update(Observation observation) {
        return repository.save(observation);
    }

    @Override
    public void delete(Observation observation) {
        repository.delete(observation);
    }

    public Observation getObservationByClient(Long id) {
        return repository.findObservationByClient(id);
    }
}
