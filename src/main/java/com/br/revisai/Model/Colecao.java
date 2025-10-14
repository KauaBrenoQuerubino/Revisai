package com.br.revisai.Model;

public class Colecao {
    private String nome;
    private Usuario[] usuarios;
    private Flashcard[] flashcards;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Flashcard[] getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Flashcard[] flashcards) {
        this.flashcards = flashcards;
    }
}
