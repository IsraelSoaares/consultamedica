package com.example.consultamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.consultamedica.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
