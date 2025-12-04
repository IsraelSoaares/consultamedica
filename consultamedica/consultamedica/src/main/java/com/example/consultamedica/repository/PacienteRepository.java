package com.example.consultamedica.repository;

import com.example.consultamedica.controller.PacienteController;
import com.example.consultamedica.models.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Pacientes, Long> {
}
