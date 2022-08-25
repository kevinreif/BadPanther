package com.example.application.data.service.behavior;

import com.example.application.data.entity.Behavior;
import com.example.application.data.entity.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BehaviorService implements CrudListener<Behavior> {
    private final BehaviorRepository repository;
    @Override
    public Collection<Behavior> findAll() {
        return repository.findAll();
    }

    @Override
    public Behavior add(Behavior behavior) {
        return repository.save(behavior);
    }

    @Override
    public Behavior update(Behavior behavior) {
        return repository.save(behavior);
    }

    @Override
    public void delete(Behavior behavior) {
        repository.delete(behavior);
    }

    public List<Behavior> getBehaviorsByClient(Long id) {
        return repository.findBehaviorsByClient(id);
    }

    /*public Behavior getBehaviorsByClient(Long id) {
        return repository.findBehaviorsByClient(id);
    }*/
}
