package com.example.consultamedica.controller;

import com.example.consultamedica.models.Consulta;
import com.example.consultamedica.models.Medicos;
import com.example.consultamedica.models.Pacientes;
import com.example.consultamedica.repository.ConsultaRepository;
import com.example.consultamedica.repository.MedicoRepository;
import com.example.consultamedica.repository.PacienteRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaController(
            ConsultaRepository consultaRepository,
            PacienteRepository pacienteRepository,
            MedicoRepository medicoRepository
    ) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    @PostMapping("/agendar")
    public ResponseEntity<String> agendarConsulta(
            @RequestParam Long pacienteId,
            @RequestParam Long medicoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime dataHora,
            @RequestParam(required = false) String motivo
    ) {

        // Verifica paciente
        Optional<Pacientes> pacienteOpt = pacienteRepository.findById(pacienteId);
        if (pacienteOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Paciente não encontrado.");
        }

        // Verifica médico
        Optional<Medicos> medicoOpt = medicoRepository.findById(medicoId);
        if (medicoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Médico não encontrado.");
        }

        // Valida horário (não pode marcar no passado)
        if (dataHora.isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("❌ A data/hora não pode ser no passado.");
        }

        // Cria consulta
        Consulta consulta = new Consulta();
        consulta.setPaciente(pacienteOpt.get());
        consulta.setMedico(medicoOpt.get());
        consulta.setDataHora(dataHora);
        consulta.setMotivo(motivo);

        consultaRepository.save(consulta);

        return ResponseEntity.ok("✔ Consulta agendada com sucesso!");
    }
}
