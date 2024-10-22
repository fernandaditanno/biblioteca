package io.github.fernandaditanno.domain.entity;

import io.github.fernandaditanno.domain.enuns.StatusEmprestimo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "usuario_id",nullable = false)
    @NotEmpty
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id",unique = true, nullable = false)
    @NotEmpty
    private Livro livro;

    @Column(nullable = false)
    @NotEmpty
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    @NotEmpty
    private LocalDate dataDevolucao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private StatusEmprestimo status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.Usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }
}
