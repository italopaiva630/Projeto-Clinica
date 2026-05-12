package com.senai.Projetods.entities;

import com.senai.Projetods.dtos.PacienteDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome não pode ser vazio")
    private String nome;
    @NotNull(message = "E-mail não pode ser vazio")
    @NotBlank(message = "E-mail não pode conter espaços vazios")
    private String email;

    public PacienteEntity() {

    }

    public PacienteEntity(PacienteDto pacienteDto) {
        if (pacienteDto.getId() > 0L) {
           this.id = pacienteDto.getId();
        }
        this.nome = pacienteDto.getNome();
        this.email = pacienteDto.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
