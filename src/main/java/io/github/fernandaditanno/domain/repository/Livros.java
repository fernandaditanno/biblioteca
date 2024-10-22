package io.github.fernandaditanno.domain.repository;

import io.github.fernandaditanno.domain.entity.Livro;
import io.github.fernandaditanno.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Livros extends JpaRepository<Livro, Integer> {

    @Query("select l from Livro l where l.id == :id")
    Optional<Livro> findAllById(Integer id);

    @Query("select l from Livro l where l.Titulo like :titulo")
    Optional<Livro> findAllByTitulo(String titulo);

    @Query("select l from Livro l where l.Autor like :autor")
    List<Livro> findAllByAutor(String autor);

    @Query("select l from Livro l where l.Categoria like :categoria")
    List<Livro> findAllByCategoria(String categoria);
}
