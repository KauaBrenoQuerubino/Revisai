package com.br.revisai.Model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "flashcard")
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String tema;

    @OneToMany(mappedBy = "flashcard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pergunta> Perguntas;

    @ManyToOne
    @JoinColumn(name = "colecao_id")
    private Colecao colecao;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Pergunta> getPerguntas() {
        return Perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        Perguntas = perguntas;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }
}
