package com.devsuperior.ClienteCRUD.repository;

import com.devsuperior.ClienteCRUD.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
