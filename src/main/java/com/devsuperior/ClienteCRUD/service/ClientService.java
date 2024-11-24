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
}
