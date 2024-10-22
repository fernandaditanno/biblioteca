package io.github.fernandaditanno.service;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.domain.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService  implements UserDetailsService {

    @Autowired
    private Usuarios usuarios;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario login = this.usuarios.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Usuario não foi encontrado!"));



        return User
                .builder()
                .username(login.getEmail())
                .password(login.getSenha())
                .roles(login.getPerfilUsuario().toString())
                .build();
    }
}
