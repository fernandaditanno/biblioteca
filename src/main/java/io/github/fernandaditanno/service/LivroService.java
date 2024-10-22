package io.github.fernandaditanno.service;

import io.github.fernandaditanno.domain.entity.Livro;
import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.domain.repository.Livros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private Livros livros;

    public Livro salvar(Livro livro) {
        return livros.save(livro);
    }

    public Livro buscarPorId(Integer id) {
        Optional<Livro> result = livros.findAllById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Livro buscarPorTitulo(String titulo) {
        Optional<Livro> result = livros.findAllByTitulo(titulo);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Livro> buscarPorAutor(String autor) {
        return livros.findAllByAutor(autor);
    }

    public List<Livro> buscarTodos() {
        return livros.findAll();
    }

    public Livro atualizar(Livro livro) {
        Optional<Livro> result = livros.findAllById(livro.getId());
        if(result.isPresent()) {
            return livros.save(livro);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void excluir(Integer id) {
        livros.deleteById(id);
    }

}
