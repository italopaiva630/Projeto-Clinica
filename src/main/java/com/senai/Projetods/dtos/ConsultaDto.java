package com.senai.Projetods.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.senai.Projetods.entities.ConsultaEntity;

import java.util.Date;

public class ConsultaDto {

    private Long id;

    private String titulo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date data;

    private String tipo;

    // ID do paciente relacionado à consulta
    private Long pacienteId;

    public ConsultaDto() {
    }

    public ConsultaDto(Long id, String titulo, Date data, String tipo, Long pacienteId) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.tipo = tipo;
        this.pacienteId = pacienteId;
    }

    public ConsultaDto(ConsultaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.data = entity.getData();
        this.tipo = entity.getTipo();

        // pega o id do paciente da consulta
        if (entity.getPaciente() != null) {
            this.pacienteId = entity.getPaciente().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}