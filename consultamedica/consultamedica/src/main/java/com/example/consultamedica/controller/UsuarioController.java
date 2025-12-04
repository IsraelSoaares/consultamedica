package com.example.consultamedica.controller;

import com.example.consultamedica.models.TipoUsuario;
import com.example.consultamedica.models.Usuario;
import com.example.consultamedica.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criarUsuario(
            @RequestBody Usuario usuario,
            @RequestParam(required = false) String crm,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String planoDeSaude,
            @RequestParam(required = false) String setor,
            @RequestParam TipoUsuario tipo
    ) {
        return usuarioService.criarUsuario(
                usuario,
                crm,
                cpf,
                planoDeSaude,
                setor,
                tipo
        );
    }
}
