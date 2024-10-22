package io.github.fernandaditanno.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty
    private String Titulo;

    @Column(nullable = false)
    @NotEmpty
    private String Autor;

    @Column(nullable = false)
    @NotEmpty
    private String ISBN;

    @Column(nullable = false)
    @NotEmpty
    private LocalDate DataPublicacao;

    @Column(nullable = false)
    @NotEmpty
    private String Categoria;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDataPublicacao() {
        return DataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        DataPublicacao = dataPublicacao;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

}
