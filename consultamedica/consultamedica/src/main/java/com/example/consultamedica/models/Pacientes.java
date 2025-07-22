package com.example.consultamedica.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Collate;
@Entity
@Table(name = "tb_pacientes")
@Getter
@Setter
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Column(unique = true)
    private String cpf;
    private String plano_de_saude;
    



}
