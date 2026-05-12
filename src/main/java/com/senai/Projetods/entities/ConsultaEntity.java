package com.senai.Projetods.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.senai.Projetods.dtos.ConsultaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Título não pode ser vazio")
    private String titulo;

    @NotNull(message = "Data não pode ser vazia")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date data;

    @NotNull(message = "Tipo não pode ser vazio")
    private String tipo; // informado no cadastro

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    public ConsultaEntity() {}

    public ConsultaEntity(ConsultaDto consultaDto, PacienteEntity paciente) {
        if (consultaDto.getId() != null) {
            this.id = consultaDto.getId();
        }

        this.titulo = consultaDto.getTitulo();
        this.data = consultaDto.getData();
        this.tipo = consultaDto.getTipo(); // obrigatório no cadastro
        this.paciente = paciente;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public PacienteEntity getPaciente() { return paciente; }
    public void setPaciente(PacienteEntity paciente) { this.paciente = paciente; }
}