package com.example.consultamedica.models;

public class UsuarioDTO {



        public String nome;
        public String email;
        public String senha;
        public String tipo; // "MEDICO", "PACIENTE", "ATENDENTE"

        // Dados específicos do médico
        public String crm;
        public String especialidade;
        public String horario_comeco;
        public String horario_fim;

        // Dados específicos do paciente
        public String cpf;
        public String plano_saude;


        // Dados específicos do atendente
        public String setor;
    }


