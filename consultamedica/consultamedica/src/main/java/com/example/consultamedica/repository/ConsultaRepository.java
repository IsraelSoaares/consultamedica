package com.example.consultamedica.repository;

import com.example.consultamedica.controller.ConsultaController;
import com.example.consultamedica.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


}
