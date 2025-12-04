package com.example.consultamedica.service;

import com.example.consultamedica.models.Medicos;
import com.example.consultamedica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medicos criarMedico(Medicos medico) {
        return medicoRepository.save(medico);
    }
}
