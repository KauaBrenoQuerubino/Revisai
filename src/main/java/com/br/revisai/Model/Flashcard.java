package com.br.revisai.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "flashcard")
public class Flashcard {

    public Flashcard() {}

    public Flashcard(int id, String nome, String tema, List<Pergunta> perguntas, Colecao colecao) {
        this.id = id;
        this.nome = nome;
        this.tema = tema;
        Perguntas = perguntas;
        this.colecao = colecao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String tema;

    @OneToMany(mappedBy = "flashcard", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Pergunta> Perguntas;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "colecao_id")
    @JsonIgnoreProperties("flashcards")
    private Colecao colecao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
