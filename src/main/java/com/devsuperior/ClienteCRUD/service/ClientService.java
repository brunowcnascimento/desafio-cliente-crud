package com.devsuperior.ClienteCRUD.service;

import com.devsuperior.ClienteCRUD.entity.Client;
import com.devsuperior.ClienteCRUD.entity.dto.ClientDTO;
import com.devsuperior.ClienteCRUD.repository.ClientRepository;
import com.devsuperior.ClienteCRUD.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client result = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));;
        return new ClientDTO(result);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoTiEntity(dto, entity);

        entity = repository.save(entity);

        return new ClientDTO(entity);
    }

    private void copyDtoTiEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());

    }
}
