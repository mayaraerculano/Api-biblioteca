package com.exemplo.biblioteca.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
