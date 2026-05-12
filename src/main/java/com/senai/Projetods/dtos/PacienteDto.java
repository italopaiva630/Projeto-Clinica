package com.senai.Projetods.dtos;

import com.senai.Projetods.entities.PacienteEntity;

public class PacienteDto {
    private Long id;
    private String nome;
    private String email;

    public PacienteDto() {

    }

    public PacienteDto(PacienteEntity entity) {
        if (entity.getId() > 0L){
            this.id = entity.getId();
        }
        this.nome = entity.getNome();
        this.email = entity.getEmail();
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
