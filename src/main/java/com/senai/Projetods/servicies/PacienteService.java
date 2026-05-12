package com.senai.Projetods.servicies;

import com.senai.Projetods.dtos.PacienteDto;
import com.senai.Projetods.entities.PacienteEntity;
import com.senai.Projetods.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;
    private List<PacienteEntity> listapaciente = new ArrayList<>();

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Boolean cadastraUsuario(PacienteDto pacienteDto) {
        if (!repository.existsByNome(pacienteDto.getNome())) {
            return false;
        }
        PacienteEntity entity = new PacienteEntity(pacienteDto);
        repository.save(entity);
        return true;
    }

    public Boolean deletarUsuario(PacienteDto pacienteDto){
        Long id = pacienteDto.getId();
        if (!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }


    public List<PacienteDto> obterPaciente() {
        List<PacienteEntity> listaPaciente = repository.findAll();
        List<PacienteDto> listaPacienteDto = new ArrayList<>();

        for (PacienteEntity entity : listaPaciente) {
            PacienteDto dto = new PacienteDto(entity);
            listaPacienteDto.add(dto);
        }

        return listaPacienteDto;
    }


    public boolean atualizapaciente(Long id, PacienteDto pacienteDto) {
        if (!repository.existsById(id)) {
            return false;
        }
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDto);
        pacienteEntity.setId(id);

        repository.save(pacienteEntity);

        return true;
    }
}
