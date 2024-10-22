package io.github.fernandaditanno.service;

import io.github.fernandaditanno.domain.entity.Emprestimo;
import io.github.fernandaditanno.domain.repository.Emprestimos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private Emprestimos emprestimos;

    public Emprestimo salvar(Emprestimo livro) {
        return emprestimos.save(livro);
    }

    public Emprestimo buscarPorId(Integer id) {
        Optional<Emprestimo> result = emprestimos.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Emprestimo> buscarTodos() {
        return emprestimos.findAll();
    }

    public Emprestimo atualizar(Emprestimo emprestimo) {
        Optional<Emprestimo> result = emprestimos.findById(emprestimo.getId());
        if(result.isPresent()) {
            return emprestimos.save(emprestimo);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void excluir(Integer id) {
        emprestimos.deleteById(Long.valueOf(id));
    }

}
