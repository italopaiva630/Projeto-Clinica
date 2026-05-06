package com.senai.Projetods.controlllers;


import com.senai.Projetods.dtos.ConsultaDto;
import com.senai.Projetods.dtos.PacienteDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senai.Projetods.servicies.ConsultaService;

@RestController
@RequestMapping("/Consulta")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }



    @PostMapping("/criaconsulta")
    public ResponseEntity<String> cadastraconsulta (@RequestBody ConsultaDto consultaDto) {

        service.cadastraconsulta(consultaDto);

        boolean retorno = true;

        if (retorno) {

            return ResponseEntity.accepted().body("Consulta cadastrado");
        }
        return ResponseEntity.badRequest().body("Consulta não cadastrada");

    }

    @GetMapping("/obterconsulta")
    public  ResponseEntity<String> obterconsulta(){
        service.exibeconsulta();

        return null;

    }
    @PutMapping("/atualizarconsulta/{id}")
    public ResponseEntity<String> atualizarconsulta (@PathVariable Long id, @RequestBody @Valid ConsultaDto consultaDto){

        service.cadastraconsulta(consultaDto);

        boolean retorno =  true;

        if(retorno){
            return ResponseEntity.accepted().body("Consulta atualizada com sucesso");
        }
        return ResponseEntity.badRequest().body("Consulta não atualizada");

    }

    @DeleteMapping("consulta/{id}")
    public ResponseEntity<Object> excluirconsulta (@PathVariable Long id){


    }






}

