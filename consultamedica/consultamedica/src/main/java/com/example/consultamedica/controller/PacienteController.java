package com.example.consultamedica.controller;

import com.example.consultamedica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Map<String, Object>> listarPacientes() {
        return pacienteRepository.findAll().stream().map(p -> {
            Map<String, Object> pacienteMap = new HashMap<>();
            pacienteMap.put("id", p.getId());
            pacienteMap.put("nome", p.getUsuario().getNome()); // pega o nome do usuário associado
            return pacienteMap;
        }).toList();
    }
    }

