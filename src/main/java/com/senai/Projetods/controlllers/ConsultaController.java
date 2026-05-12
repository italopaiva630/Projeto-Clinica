package com.senai.Projetods.controlllers;


import com.senai.Projetods.dtos.ConsultaDto;
import com.senai.Projetods.dtos.PacienteDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senai.Projetods.servicies.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consultas") // Define a rota base: localhost:8080/consultas
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping("/consulta")
    public ResponseEntity<String> cadastrar(@RequestBody ConsultaDto dto) {
        if (service.cadastraconsulta(dto)) {
            return ResponseEntity.ok("Consulta cadastrada com sucesso!");
        }
        return ResponseEntity.badRequest().body("Erro: Título de consulta já existe.");
    }

    @GetMapping("/consultas")
    public ResponseEntity<List<ConsultaDto>> listar() {
        return ResponseEntity.ok(service.obterConsulta());
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody ConsultaDto dto) {
        if (service.atualizaConsulta(id, dto)) {
            return ResponseEntity.ok("Consulta atualizada com sucesso!");
        }
        return ResponseEntity.status(404).body("Consulta com ID " + id + " não encontrada.");
    }

    @DeleteMapping("/consulta1")
    public ResponseEntity<String> deletar(@RequestBody ConsultaDto dto) {
        if (service.deletarConsulta(dto)) {
            return ResponseEntity.ok("Consulta deletada com sucesso!");
        }
        return ResponseEntity.status(404).body("Erro: Consulta não encontrada para deletar.");
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<String> cancelarConsulta(@PathVariable Long id) {
        if (service.cancelarConsulta(id)){
            return ResponseEntity.ok("Consulta cancelada!");
        }
        return ResponseEntity.status(404).body("Erro: consulta não encontrada!");
    }
}

