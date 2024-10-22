package io.github.fernandaditanno.service;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.domain.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioService{

    @Autowired
    private Usuarios usuarios;

    public Usuario salvar(Usuario usuario) {
        if (!this.ValidarSenhaForte(usuario.getSenha())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Senha fraca!");
        }else if (!this.ValidarEmail(usuario.getEmail())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Informe um e-mail!");
        }else if (usuario.getNome().length() <5) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Informe um nome completo");
        }else if (!this.ValidarTelefone(usuario.getTelefone())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Informe um numero de telefone valido");
        }
        return usuarios.save(usuario);
    }

    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> resto = usuarios.findById(id);
        if(resto.isPresent()) {
            return resto.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Usuario> buscarTodos() {
        return usuarios.findAll();
    }

    public void excluir(Integer id) {
        usuarios.deleteById(id);
    }

    public Usuario atualizar(Usuario usuario) {
        String nome = " %" + usuario.getNome() + "% ";
        Optional<Usuario> resto = usuarios.findByNome(nome);
        if(resto.isPresent()) {
            if (!this.ValidarSenhaForte(usuario.getSenha())) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Senha fraca!");
            }else if (!this.ValidarEmail(usuario.getEmail())) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Informe um e-mail!");
            }else if (usuario.getNome().length() <5) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Informe um nome completo");
            }else if (!this.ValidarTelefone(usuario.getTelefone())) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Informe um numero de telefone valido");
            }
            usuario.setId(resto.get().getId());
            return usuarios.save(usuario);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Usuario buscarPorNome(String nome) {
        String usuario = " %" + nome + "% ";
        Optional<Usuario> resto = usuarios.findByNome(usuario);
        if(resto.isPresent()) {
            return resto.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Usuario ataulizarSenhaDoUsuario(Integer idUduario, String senha, String confirmarSenha){
        if (senha != confirmarSenha) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else {
            if (ValidarSenhaForte(senha)){
                Usuario novaSenha = buscarPorId(idUduario);
                novaSenha.setSenha(senha);
                return usuarios.save(novaSenha);
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
    }
    private Boolean ValidarEmail(String email) {
        String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern upperCasePattern = Pattern.compile(EMAIL_REGEX);
        Matcher upperCaseMatcher = upperCasePattern.matcher(email);
        if (!upperCaseMatcher.find()) {
            return false;
        }
        return true;
    }

    private Boolean ValidarTelefone(String email) {
        String FONE_REGEX = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
        Pattern upperCasePattern = Pattern.compile(FONE_REGEX);
        Matcher upperCaseMatcher = upperCasePattern.matcher(email);
        if (!upperCaseMatcher.find()) {
            return false;
        }
        return true;
    }

    private Boolean ValidarSenhaForte(String senha) {
        if (senha.length() < 8) {
            return false;
        }
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Matcher upperCaseMatcher = upperCasePattern.matcher(senha);
        if (!upperCaseMatcher.find()) {
            return false;
        }
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(senha);
        if (!lowerCaseMatcher.find()) {
            return false;
        }
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(senha);
        if (!digitMatcher.find()) {
            return false;
        }
        Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(senha);
        if (!specialCharacterMatcher.find()) {
            return false;
        }

        return true;
    }


}
