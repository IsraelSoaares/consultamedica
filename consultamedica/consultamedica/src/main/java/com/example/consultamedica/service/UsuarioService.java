package com.example.consultamedica.service;

import com.example.consultamedica.models.Atendente;
import com.example.consultamedica.models.Medicos;
import com.example.consultamedica.models.Pacientes;
import com.example.consultamedica.models.TipoUsuario;
import com.example.consultamedica.models.Usuario;
import com.example.consultamedica.repository.AtendenteRepository;
import com.example.consultamedica.repository.MedicoRepository;
import com.example.consultamedica.repository.PacienteRepository;
import com.example.consultamedica.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final AtendenteRepository atendenteRepository;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            MedicoRepository medicoRepository,
            PacienteRepository pacienteRepository,
            AtendenteRepository atendenteRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
        this.atendenteRepository = atendenteRepository;
    }

    public Usuario criarUsuario(
            Usuario usuario,
            String crm,
            String cpf,
            String planoDeSaude,
            String setor,
            TipoUsuario tipo
    ) {

        usuarioRepository.save(usuario);

        switch (tipo) {

            case MEDICO -> {
                Medicos medico = new Medicos();
                medico.setCrm(crm);
                medico.setUsuario(usuario);
                medicoRepository.save(medico);
            }

            case PACIENTE -> {
                Pacientes paciente = new Pacientes();
                paciente.setCpf(cpf);
                paciente.setPlano_de_saude(planoDeSaude);
                paciente.setUsuario(usuario);
                pacienteRepository.save(paciente);
            }

            case ATENDENTE -> {
                Atendente atendente = new Atendente();
                atendente.setSetor(setor);
                atendente.setUsuario(usuario);
                atendenteRepository.save(atendente);
            }
        }

        return usuario;
    }
}
