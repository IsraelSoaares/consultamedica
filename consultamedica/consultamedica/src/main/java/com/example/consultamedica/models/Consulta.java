package com.example.consultamedica.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consultas")
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relaciona consulta com o paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Pacientes paciente;

    // Relaciona consulta com o médico
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medicos medico;

    private LocalDateTime dataHora;

    private String motivo; // motivo da consulta, opcional
}
