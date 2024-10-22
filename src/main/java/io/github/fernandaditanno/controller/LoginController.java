package io.github.fernandaditanno.controller;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }
}
