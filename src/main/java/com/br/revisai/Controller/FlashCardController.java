package com.br.revisai.Controller;

import com.br.revisai.Model.Colecao;
import com.br.revisai.Model.Flashcard;
import com.br.revisai.Service.ColecaoService;
import com.br.revisai.Service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Flashcard")
public class FlashCardController{

    @Autowired
    FlashcardService service;

    @Autowired
    ColecaoService colecaoRepository;


    @PostMapping
    public ResponseEntity<Flashcard> create(@RequestBody Flashcard flashcard){
        if (flashcard.getColecao() == null || flashcard.getColecao().getId() == 0) {
            return ResponseEntity.badRequest().build();
        }

        // 2️⃣ Busca a coleção existente no banco
        Colecao colecao = colecaoRepository.findById(flashcard.getColecao().getId())
                .orElseThrow(() -> new RuntimeException("Coleção não encontrada"));

        // 3️⃣ Substitui a coleção “transiente” pela coleção gerenciada
        flashcard.setColecao(colecao);

        // 4️⃣ Salva o flashcard
        Flashcard saved = service.save(flashcard);

        // 5️⃣ Retorna o flashcard salvo (com ID e outros campos)
        return ResponseEntity.ok(saved);
    }
}
