package io.github.fernandaditanno.domain.repository;

import io.github.fernandaditanno.domain.entity.Emprestimo;
import io.github.fernandaditanno.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Emprestimos extends JpaRepository<Emprestimo, Long> {

    @Query("select e from Emprestimo e where e.id == :id")
    Optional<Emprestimo> findById(Integer id);

    @Query("select e from Emprestimo e where e.Usuario == :usuario")
    List<Emprestimo> findByUsuario(Usuario usuario);


}
