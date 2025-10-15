package com.br.revisai.Controller;

import com.br.revisai.Model.Flashcard;
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

    @PostMapping
    public ResponseEntity<Flashcard> create(@RequestBody Flashcard flashcard){
        service.save(flashcard);
        return ResponseEntity.ok(flashcard);
    }
}
