package com.br.revisai.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "pergunta")
public class Pergunta {

    public Pergunta() {}

    public Pergunta(String enunciado, String resposta, String dificuldade, Flashcard flashcard) {
        this.enunciado = enunciado;
        this.resposta = resposta;
        this.dificuldade = dificuldade;
        this.flashcard = flashcard;
    }

    //TODO: Fazer o FK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String enunciado;
    private String resposta;
    private String dificuldade;

    @ManyToOne
    @JoinColumn(name = "flashcard_id")
    @JsonIgnoreProperties("perguntas")
    private Flashcard flashcard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Flashcard getFlashcard() {
        return flashcard;
    }

    public void setFlashcard(Flashcard flashcard) {
        this.flashcard = flashcard;
    }
}
