package com.senai.Projetods.controlllers;

import com.senai.Projetods.dtos.PacienteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senai.Projetods.servicies.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteControler {

    private final PacienteService service;

    public PacienteControler(PacienteService service) {
        this.service = service;
    }

    @PostMapping("/paciente")
    public ResponseEntity<String> cadastrar(@RequestBody PacienteDto dto) {
        if (service.cadastraUsuario(dto)) {
            return ResponseEntity.ok("Paciente cadastrado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Erro ao cadastrar: Paciente já existe.");
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDto>> listar() {
        return ResponseEntity.ok(service.obterPaciente());
    }

    // Atualização usando o ID na URL (/pacientes/1)
    @PutMapping("/atualiza/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody PacienteDto dto) {
        if (service.atualizapaciente(id, dto)) {
            return ResponseEntity.ok("Paciente atualizado com sucesso!");
        }
        return ResponseEntity.status(404).body("Paciente com ID " + id + " não encontrado.");
    }

    @DeleteMapping("/paciente1")
    public ResponseEntity<String> deletar(@RequestBody PacienteDto dto) {
        if (service.deletarUsuario(dto)) {
            return ResponseEntity.ok("Paciente deletado com sucesso!");
        }
        return ResponseEntity.status(404).body("Erro: Paciente não encontrado.");
    }
}


