package com.br.revisai.Controller;


import com.br.revisai.Model.Flashcard;
import com.br.revisai.Model.Pergunta;
import com.br.revisai.Service.FlashcardService;
import com.br.revisai.Service.PerguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Perguntas")
public class PerguntasController {

    @Autowired
    PerguntasService service;

    @Autowired
    private FlashcardService flashcardRepository;

    @PostMapping
    public ResponseEntity<Pergunta> criarPergunta(@RequestBody Pergunta pergunta){
        // Busca o flashcard já salvo no banco
        Flashcard flashcardExistente = flashcardRepository.findById(pergunta.getFlashcard().getId())
                .orElseThrow(() -> new RuntimeException("Flashcard não encontrado"));

        // Associa o flashcard existente
        pergunta.setFlashcard(flashcardExistente);

        // Salva a pergunta
        Pergunta nova = service.save(pergunta);
        return ResponseEntity.ok(nova);
    }
}
