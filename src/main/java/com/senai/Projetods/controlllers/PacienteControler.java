package com.senai.Projetods.controlllers;

import com.senai.Projetods.dtos.PacienteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senai.Projetods.servicies.PacienteService;

@RestController
@RequestMapping("/Paciente")
public class PacienteControler {


    private final PacienteService service;

        public PacienteControler(PacienteService service) {
            this.service = service;
        }


        @PostMapping("/criapaciente")
        public ResponseEntity<String> cadastrausuario (@RequestBody PacienteDto pacienteDto){
            service.cadastrausuario(pacienteDto);

            boolean retorno = true;

            if(retorno){
                return ResponseEntity.accepted().body("Paciente Cadastrado");
            }

            return ResponseEntity.badRequest().body("Paciente Não Cadastrado");

        }

        @GetMapping("/obterpaciente")
        public ResponseEntity<String> obterpaciente (){

            service.exibepaciente();

            return null;

        }






    }


