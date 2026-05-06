package com.senai.Projetods.repositories;

import com.senai.Projetods.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity,Integer> {

}
