package io.github.fernandaditanno.controller;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> Listar(){
        return this.usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Integer id){
        return this.usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id){
        this.usuarioService.excluir(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario){
        return this.usuarioService.atualizar(usuario);
    }

    @PutMapping("/nova-senha/{id}")
    public Usuario atualizarSenha(@PathVariable Integer id, @RequestParam String senha, @RequestParam String confirmaSenha){
        return this.usuarioService.ataulizarSenhaDoUsuario(id, senha, confirmaSenha);
    }
}
