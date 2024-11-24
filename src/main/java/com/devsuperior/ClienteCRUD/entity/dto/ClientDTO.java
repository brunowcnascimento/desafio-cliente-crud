package com.devsuperior.ClienteCRUD.entity.dto;

import com.devsuperior.ClienteCRUD.entity.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {
    private Long id;

    @NotEmpty
    private String name;
    private String cpf;
    private Double income;

    @PastOrPresent
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public @NotEmpty String getName() {
        return name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientDTO clientDTO)) return false;
        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
