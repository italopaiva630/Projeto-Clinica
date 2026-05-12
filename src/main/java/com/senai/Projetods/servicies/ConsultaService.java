package com.senai.Projetods.servicies;


import com.senai.Projetods.dtos.ConsultaDto;
import com.senai.Projetods.dtos.PacienteDto;
import com.senai.Projetods.entities.ConsultaEntity;
import com.senai.Projetods.entities.PacienteEntity;
import com.senai.Projetods.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    private List<ConsultaEntity> listaconsulta = new ArrayList<>();


    public Boolean cadastraconsulta(ConsultaDto consultaDto) {
            if (repository.existsByTitulo(consultaDto.getTitulo())) {
                return false;
            }
        ConsultaEntity entity = new ConsultaEntity(consultaDto);
            repository.save(entity);
            return true;
    }

    public Boolean deletarConsulta(ConsultaDto consultaDto){
        Long id = consultaDto.getId();
        if (!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public List<ConsultaDto> obterConsulta() {
        List<ConsultaEntity> listaConsulta = repository.findAll();
        List<ConsultaDto> listaConsultaDto = new ArrayList<>();

        for (ConsultaEntity entity : listaConsulta) {
            ConsultaDto dto = new ConsultaDto(entity);
            listaConsultaDto.add(dto);
        }

        return listaConsultaDto;
    }

    public boolean atualizaPaciente(Long id, ConsultaDto consultaDto) {
        if (!repository.existsById(id)) {
            return false;
        }
        ConsultaEntity entity = new ConsultaEntity(consultaDto);
        entity.setId(id);

        repository.save(entity);
        return true;
    }


}
