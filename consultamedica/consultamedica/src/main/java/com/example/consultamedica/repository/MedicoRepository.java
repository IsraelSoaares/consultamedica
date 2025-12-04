package com.example.consultamedica.repository;

import com.example.consultamedica.controller.MedicoController;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.consultamedica.models.Medicos;

public interface MedicoRepository extends JpaRepository<Medicos, Long> {


}
