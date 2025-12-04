package com.example.consultamedica.controller;

import com.example.consultamedica.models.Pacientes;
import com.example.consultamedica.repository.PacienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping
    public Pacientes criarPaciente(@RequestBody Pacientes paciente) {
        return pacienteRepository.save(paciente);
    }

    @GetMapping
    public List<Pacientes> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pacientes buscarPorId(@PathVariable Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }
}
