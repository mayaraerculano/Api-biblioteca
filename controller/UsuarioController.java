package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Livro> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Livro criarUsuario(@RequestBody Livro usuario) {
        return usuarioService.salvarUsuario(usuario);
    }
}
