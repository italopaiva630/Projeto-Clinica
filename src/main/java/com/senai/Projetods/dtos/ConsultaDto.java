package com.senai.Projetods.dtos;

import com.senai.Projetods.entities.ConsultaEntity;

import java.util.Date;

public class ConsultaDto {
    private Long id;
    private String titulo;
    private Date data;
    private String status;

    public ConsultaDto(Long id, String titulo, Date data, String status) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.status = status;
    }

    public ConsultaDto(ConsultaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.data = entity.getData(); // ou getData() conforme seu campo
        this.status = entity.getStatus();
    }

    public ConsultaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
