package com.br.revisai.Controller;

import com.br.revisai.Model.Colecao;
import com.br.revisai.Service.ColecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Colecao")
public class ColecaoController {

    @Autowired
    ColecaoService service;

    @PostMapping
    public ResponseEntity<Colecao> create(@RequestBody Colecao colecao){
        service.save(colecao);
        return ResponseEntity.ok(colecao);
    }
}
