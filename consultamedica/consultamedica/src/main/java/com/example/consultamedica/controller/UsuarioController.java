package com.example.consultamedica.controller;

import com.example.consultamedica.models.*;
import com.example.consultamedica.repository.AtendenteRepository;
import com.example.consultamedica.repository.MedicoRepository;
import com.example.consultamedica.repository.PacienteRepository;
import com.example.consultamedica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com .example.consultamedica.models.TipoUsuario;
import com.example.consultamedica.models.Pacientes;

import java.time.LocalDate;
import java.util.Date;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    @Autowired
    private AtendenteRepository atendenteRepository;

    @PostMapping("/cadastrar")


    public String cadastrarUsuario(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam int senha,
            @RequestParam TipoUsuario tipo,

            @RequestParam(required = false) Integer crm,
            @RequestParam(required = false) String especialidade,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate horario_comeco,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate horario_fim,


            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String plano_de_saude,


            @RequestParam(required = false) String setor
    ){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setTipo(tipo);

        usuarioRepository.save(usuario);

        switch (usuario.getTipo()) {
            case MEDICO -> {
                Medicos medico = new Medicos();
                medico.setCrm(crm);
                medico.setEspecialidade(especialidade);
                medico.setHorario_comeco(horario_comeco);
                medico.setHorario_fim(horario_fim);
                medico.setUsuario(usuario);
                medicoRepository.save(medico);
            }

            case PACIENTE -> {
                Pacientes paciente = new Pacientes();
                paciente.setCpf(cpf);
                paciente.setPlano_de_saude(plano_de_saude);
                paciente.setUsuario((usuario));
                pacienteRepository.save(paciente);
            }
            case ATENDENTE -> {
                Atendente atendente = new Atendente();
                atendente.setSetor(setor);
                atendente.setUsuario(usuario);
                atendenteRepository.save(atendente);
            }
        }
        return "redirect:/login"; // Redireciona após cadastro


    }
}
