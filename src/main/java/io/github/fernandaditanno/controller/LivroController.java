package io.github.fernandaditanno.controller;

import io.github.fernandaditanno.domain.entity.Livro;
import io.github.fernandaditanno.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return this.livroService.salvar(livro);
    }

    @GetMapping
    public List<Livro> Listar(){
        return this.livroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Integer id){
        return this.livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id){
        this.livroService.excluir(id);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@RequestBody Livro livro){
        return this.livroService.atualizar(livro);
    }
}
