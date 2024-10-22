package io.github.fernandaditanno.domain.repository;

import io.github.fernandaditanno.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.id == :id")
    Optional<Usuario> findById(Integer id);

    @Query("select u from Usuario u where u.nome like :nome")
    Optional<Usuario> findByNome(String nome);

    @Query("select u from Usuario u where u.email like :email")
    Optional<Usuario> findByEmail(String email);
}
