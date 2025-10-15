package com.br.revisai.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "colecao")
public class Colecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

//    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "colecao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flashcard> flashcards;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Usuario> usuarios) {
//        this.usuarios = usuarios;
//    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }
}
