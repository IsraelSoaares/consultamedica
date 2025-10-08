package com.example.consultamedica.controller;

import com.example.consultamedica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Map<String, Object>> listarMedicos() {
        return medicoRepository.findAll().stream().map(m -> {
            Map<String, Object> medicoMap = new HashMap<>();
            medicoMap.put("id", m.getId());
            medicoMap.put("nome", m.getUsuario().getNome()); // nome do médico via usuário
            return medicoMap;
        }).toList();
    }
}
