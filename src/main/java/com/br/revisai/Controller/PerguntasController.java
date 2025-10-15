package com.br.revisai.Controller;


import com.br.revisai.Model.Pergunta;
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

    @PostMapping
    public ResponseEntity<Pergunta> criarPergunta(@RequestBody Pergunta pergunta){
        service.save(pergunta);
        return ResponseEntity.ok(pergunta);
    }
}
