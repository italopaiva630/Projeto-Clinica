package com.senai.Projetods.servicies;

import com.senai.Projetods.dtos.PacienteDto;
import com.senai.Projetods.entities.PacienteEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

        private List<PacienteEntity> listapaciente = new ArrayList<>();


        public Boolean cadastrausuario(PacienteDto pacienteDto) {
            for (PacienteEntity entity : listapaciente) {
                if (entity.getNome().equals(pacienteDto.getNome())) {
                    return false;
                }
            }
            PacienteEntity pacienteEntity = new PacienteEntity();

            pacienteEntity.setNome(pacienteDto.getNome());
            pacienteEntity.setEmail(pacienteDto.getEmail());
            listapaciente.add(pacienteEntity);

            return true;
        }


        public List<PacienteEntity> exibepaciente(){

            for(PacienteEntity pacienteEntity : listapaciente){
                System.out.println(pacienteEntity);

            }


            return listapaciente;


        }



        public boolean atualizapaciente(PacienteDto pacienteDto){

            for(PacienteEntity pacienteEntity : listapaciente)
                if(!pacienteEntity.getNome().equals(pacienteDto.getNome())){

                    return false;
                }

            else
                {

                }

            return true;


    }
}
