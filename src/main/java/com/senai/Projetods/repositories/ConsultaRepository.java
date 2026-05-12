package com.senai.Projetods.repositories;

import com.senai.Projetods.entities.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
    boolean existsByTitulo(String titulo);

}
