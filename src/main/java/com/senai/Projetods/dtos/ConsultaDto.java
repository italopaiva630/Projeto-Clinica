package com.senai.Projetods.dtos;

import java.util.Date;

public class ConsultaDto {
    private Long id;
    private String titulo;
    private Date dataConsulta;
    private String status;

    public ConsultaDto(Long id, String titulo, Date dataConsulta, String status) {
        this.id = id;
        this.titulo = titulo;
        this.dataConsulta = dataConsulta;
        this.status = status;
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

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
