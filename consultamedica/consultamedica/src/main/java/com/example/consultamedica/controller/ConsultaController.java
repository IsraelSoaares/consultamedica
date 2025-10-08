package com.example.consultamedica.controller;

import com.example.consultamedica.models.Consulta;
import com.example.consultamedica.models.Medicos;
import com.example.consultamedica.models.Pacientes;
import com.example.consultamedica.repository.ConsultaRepository;
import com.example.consultamedica.repository.MedicoRepository;
import com.example.consultamedica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;



    @PostMapping("/agendar")
    public ResponseEntity<String> agendarConsulta(
            @RequestParam Long pacienteId,
            @RequestParam Long medicoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHora,
            @RequestParam(required = false) String motivo
    ) {
        Optional<Pacientes> pacienteOpt = pacienteRepository.findById(pacienteId);
        if (pacienteOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        }

        Optional<Medicos> medicoOpt = medicoRepository.findById(medicoId);
        if (medicoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Médico não encontrado");
        }
        Consulta consulta = new Consulta();
        consulta.setPaciente(pacienteOpt.get());
        consulta.setMedico(medicoOpt.get());
        consulta.setDataHora(dataHora);
        consulta.setMotivo(motivo);

        consultaRepository.save(consulta);

        return  ResponseEntity.ok("Consulta agendada com sucesso!");


    }
    }
