package com.example.consultamedica.controller;

import com.example.consultamedica.models.Medicos;
import com.example.consultamedica.repository.MedicoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    public Medicos criarMedico(@RequestBody Medicos medico) {
        return medicoRepository.save(medico);
    }

    @GetMapping
    public List<Medicos> listarMedicos() {
        return medicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Medicos buscarPorId(@PathVariable Long id) {
        return medicoRepository.findById(id).orElse(null);
    }
}
