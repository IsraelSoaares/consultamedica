package com.example.consultamedica.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "tb_medicos")
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private int crm;
    private String especialidade;
    private LocalDate horario_comeco;
    private LocalDate horario_fim;
}
