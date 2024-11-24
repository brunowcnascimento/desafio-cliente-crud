package com.devsuperior.ClienteCRUD.entity.dto;

import com.devsuperior.ClienteCRUD.entity.Client;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;

    @NotEmpty
    private String nome;
    private String cpf;
    private Double income;

    @PastOrPresent
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Long id, String nome, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public @NotEmpty String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public @PastOrPresent LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
