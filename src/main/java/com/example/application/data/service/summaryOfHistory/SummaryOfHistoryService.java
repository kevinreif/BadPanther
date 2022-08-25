package com.example.application.data.service.summaryOfHistory;

import com.example.application.data.entity.SummaryOfHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SummaryOfHistoryService implements CrudListener<SummaryOfHistory> {
    private final SummaryOfHistoryRepository repository;

    @Override
    public Collection<SummaryOfHistory> findAll() {
        return repository.findAll();
    }

    @Override
    public SummaryOfHistory add(SummaryOfHistory summaryOfHistory) {
        return repository.save(summaryOfHistory);
    }

    @Override
    public SummaryOfHistory update(SummaryOfHistory summaryOfHistory) {
        return repository.save(summaryOfHistory);
    }

    @Override
    public void delete(SummaryOfHistory summaryOfHistory) {
        repository.delete(summaryOfHistory);
    }

    public SummaryOfHistory getSummaryOfHistoryByClient(Long id) {
        return repository.findSummaryOfHistoryByClient(id);
    }
}
