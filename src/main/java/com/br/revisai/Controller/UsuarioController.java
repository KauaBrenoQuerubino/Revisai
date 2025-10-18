package com.br.revisai.Controller;

import com.br.revisai.Model.Usuario;
import com.br.revisai.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {


    //TODO: Fazer o outros metodos

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        service.save(usuario);
        return ResponseEntity.ok(usuario);
    }




}
