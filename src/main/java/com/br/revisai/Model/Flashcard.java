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

    public Flashcard(int id, String nome, String tema, String enunciado, String resposta, String dificuldade, Colecao colecao) {
        this.id = id;
        this.nome = nome;
        this.tema = tema;
        this.enunciado = enunciado;
        this.resposta = resposta;
        this.dificuldade = dificuldade;
        this.colecao = colecao;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tema='" + tema + '\'' +
                ", enunciado='" + enunciado + '\'' +
                ", resposta='" + resposta + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", colecao=" + colecao +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String tema;

    private String enunciado;
    private String resposta;
    private String dificuldade;

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

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

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }
}
