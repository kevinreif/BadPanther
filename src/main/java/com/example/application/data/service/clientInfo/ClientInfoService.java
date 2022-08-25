package com.example.application.data.service.clientInfo;

import com.example.application.data.entity.ClientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientInfoService implements CrudListener<ClientInfo> {

    private final ClientInfoRepository repository;

    @Override
    public Collection<ClientInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public ClientInfo add(ClientInfo clientInfo) {
        return repository.save(clientInfo);
    }

    @Override
    public ClientInfo update(ClientInfo clientInfo) {
        /*if (clientInfo == null) {
            System.err.println("No client selected");
            return;
        }*/
        return repository.save(clientInfo);
    }

    @Override
    public void delete(ClientInfo clientInfo) {
        repository.delete(clientInfo);
    }

    public List<ClientInfo> findAllClients(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return repository.findAll();
        } else {
            return repository.search(stringFilter);
        }
    }

    public List<ClientInfo> findAllClientsByUser(String stringFilter, UUID id) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return repository.findAllByUserID(id);
        } else {
            return repository.searchByUserID(stringFilter, id);
        }
    }
}
