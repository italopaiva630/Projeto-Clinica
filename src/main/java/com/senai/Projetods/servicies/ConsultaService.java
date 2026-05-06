package com.senai.Projetods.servicies;


import com.senai.Projetods.dtos.ConsultaDto;
import com.senai.Projetods.dtos.PacienteDto;
import com.senai.Projetods.entities.ConsultaEntity;
import com.senai.Projetods.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {


    private List<ConsultaEntity> listaconsulta = new ArrayList<>();


    public Boolean cadastraconsulta(ConsultaDto consultaDto) {
        for (ConsultaEntity entity : listaconsulta) {
            if (entity.getTitulo().equals(consultaDto.getTitulo())) {
                return false;
            }

        }
        ConsultaEntity consultaEntity = new ConsultaEntity();

        consultaEntity.setTitulo(consultaDto.getTitulo());
        consultaEntity.setData(consultaDto.getDataConsulta());
        consultaEntity.setId(consultaDto.getId());
        consultaEntity.setStatus(consultaDto.getStatus());

        listaconsulta.add(consultaEntity);

        return null;


    }

    public List<ConsultaEntity> exibeconsulta() {

        for (ConsultaEntity consultaEntity : listaconsulta) {
            System.out.println(consultaEntity);
        }
        return listaconsulta;

    }

    public Boolean atualizaconsulta(ConsultaDto consultaDto) {

        for (ConsultaEntity consultaEntity : listaconsulta)
            if (!consultaEntity.getTitulo().equals(consultaDto.getTitulo())) {



                return false;

            }

        ConsultaEntity entity = new ConsultaEntity();

        entity.setData(consultaDto.getDataConsulta());
        entity.setStatus(consultaDto.getStatus());
        entity.getId()3''


        return true;
    }


}
