package com.senai.Projetods.servicies;

import com.senai.Projetods.dtos.ConsultaDto;
import com.senai.Projetods.entities.ConsultaEntity;
import com.senai.Projetods.entities.PacienteEntity;
import com.senai.Projetods.repositories.ConsultaRepository;
import com.senai.Projetods.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;
    private final PacienteRepository pacienteRepository;

    public ConsultaService(ConsultaRepository repository, PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository;
    }

    public Boolean cadastraconsulta(ConsultaDto consultaDto) {
        if (repository.existsByTitulo(consultaDto.getTitulo())) {
            return false;
        }

        PacienteEntity paciente = pacienteRepository.findById(consultaDto.getPacienteId()).orElse(null);
        if (paciente == null) {
            return false;
        }

        ConsultaEntity entity = new ConsultaEntity(consultaDto, paciente);
        repository.save(entity);

        return true;
    }

    public Boolean deletarConsulta(ConsultaDto consultaDto) {
        Long id = consultaDto.getId();
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public List<ConsultaDto> obterConsulta() {
        List<ConsultaEntity> listaConsulta = repository.findAll();
        List<ConsultaDto> listaConsultaDto = new ArrayList<>();

        for (ConsultaEntity entity : listaConsulta) {
            listaConsultaDto.add(new ConsultaDto(entity));
        }
        return listaConsultaDto;
    }

    public boolean atualizaConsulta(Long id, ConsultaDto consultaDto) {
        if (!repository.existsById(id)) {
            return false;
        }

        PacienteEntity paciente = pacienteRepository.findById(consultaDto.getPacienteId()).orElse(null);
        if (paciente == null) {
            return false;
        }

        ConsultaEntity entity = new ConsultaEntity(consultaDto, paciente);
        entity.setId(id);

        repository.save(entity);
        return true;
    }

    public boolean cancelarConsulta(Long id) {
        ConsultaEntity consulta = repository.findById(id).orElse(null);
        if (consulta == null) {
            return false;
        }

        consulta.setTipo("Cancelada");
        repository.save(consulta);

        return true;
    }
}