package com.senai.Projetods.repositories;

import com.senai.Projetods.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {

    boolean existsByNome(String nome);


}
