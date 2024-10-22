package io.github.fernandaditanno.controller;

import io.github.fernandaditanno.domain.entity.Emprestimo;
import io.github.fernandaditanno.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo) {
        return this.emprestimoService.salvar(emprestimo);
    }

    @GetMapping
    public List<Emprestimo> Listar(){
        return this.emprestimoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscarPorId(@PathVariable Integer id){
        return this.emprestimoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id){
        this.emprestimoService.excluir(id);
    }

    @PutMapping("/{id}")
    public Emprestimo atualizar(@RequestBody Emprestimo emprestimo){
        return this.emprestimoService.atualizar(emprestimo);
    }
}
