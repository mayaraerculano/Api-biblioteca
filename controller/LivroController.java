package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.dto.LivroDTO;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Livro criar(@RequestBody LivroDTO dto) {
        Livro livro = new Livro(dto.getTitulo(), dto.getAutor());
        return service.salvar(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        Optional<Livro> livro = service.buscarPorId(id);
        return livro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody LivroDTO dto) {
        Optional<Livro> livroOptional = service.buscarPorId(id);
        if (!livroOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Livro livro = livroOptional.get();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        service.salvar(livro);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Livro> livroOptional = service.buscarPorId(id);
        if (!livroOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

