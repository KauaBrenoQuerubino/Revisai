package com.br.revisai.Model;

import java.util.HashMap;

public class Flashcard {
    private String nome;
    private String tema;
    private HashMap<String, String> Perguntas;

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

    public HashMap<String, String> getPerguntas() {
        return Perguntas;
    }

    public void setPerguntas(HashMap<String, String> perguntas) {
        Perguntas = perguntas;
    }
}
